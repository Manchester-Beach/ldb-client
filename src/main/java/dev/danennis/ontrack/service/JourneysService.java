package dev.danennis.ontrack.service;

import com.thalesgroup.rtti._2007_10_10.ldb.commontypes.FilterType;
import com.thalesgroup.rtti._2013_11_28.token.types.AccessToken;
import com.thalesgroup.rtti._2017_10_01.ldb.GetBoardRequestParams;
import com.thalesgroup.rtti._2017_10_01.ldb.LDBServiceSoap;
import com.thalesgroup.rtti._2017_10_01.ldb.Ldb;
import com.thalesgroup.rtti._2017_10_01.ldb.StationBoardWithDetailsResponseType;
import com.thalesgroup.rtti._2017_10_01.ldb.types.CallingPoint;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ServiceItemWithCallingPoints;
import dev.danennis.ontrack.model.journey.Destination;
import dev.danennis.ontrack.model.journey.Journey;
import dev.danennis.ontrack.model.journey.JourneyBoard;
import dev.danennis.ontrack.model.journey.Origin;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JourneysService {
    public JourneyBoard getJourneys(String originCRS, String destinationCRS) {
        AccessToken accessToken = new AccessToken();
        accessToken.setTokenValue("1a372d9f-307e-4016-93c5-6cbfd3d52336");
        GetBoardRequestParams params = new GetBoardRequestParams();
        params.setCrs(originCRS);
        params.setFilterCrs(destinationCRS);
        params.setFilterType(FilterType.TO);
        params.setTimeWindow(120);
        LDBServiceSoap service = new Ldb().getLDBServiceSoap12();
        StationBoardWithDetailsResponseType responseType = service.getDepBoardWithDetails(params, accessToken);
        return formatResponse(responseType);
    }

    public JourneyBoard formatResponse(StationBoardWithDetailsResponseType response) {
        List<ServiceItemWithCallingPoints> departures = response.getGetStationBoardResult().getTrainServices().getService();
        List<Journey> departuresList = new ArrayList<>();
        for (ServiceItemWithCallingPoints departure : departures) {
            Journey journey = new Journey();
            journey.setId(departure.getServiceID());
            // Origin
            Origin origin = new Origin();
            origin.setCrs(response.getGetStationBoardResult().getCrs());
            origin.setName(response.getGetStationBoardResult().getLocationName());
            origin.setScheduled(departure.getStd());
            String etd = departure.getEtd();
            if (etd.equals("On time")) {
                origin.setEstimated(departure.getStd());
            }
            else if (etd.equals("Cancelled")) {
                origin.setEstimated("");
            }
            else {
                origin.setEstimated(departure.getEtd());
            }
            journey.setOrigin(origin);
            //destination
            for (CallingPoint callingPoint : departure.getSubsequentCallingPoints().getCallingPointList().get(0).getCallingPoint()) {
                if (callingPoint.getCrs().equals(response.getGetStationBoardResult().getFiltercrs())) {
                    Destination destination = new Destination();
                    destination.setCrs(callingPoint.getCrs());
                    destination.setName(callingPoint.getLocationName());
                    destination.setScheduled(callingPoint.getSt());
                    if (callingPoint.getEt().equals("On time")) {
                        destination.setEstimated(callingPoint.getSt());
                    }
                    else if(callingPoint.getEt().equals("Cancelled")) {
                        destination.setEstimated("");
                    }
                    else {
                        destination.setEstimated(callingPoint.getEt());
                    }
                    journey.setDestination(destination);
                    //
                }
            }
            if (departure.isIsCancelled() == null) {
                journey.setIsCancelled(false);
            }
            else {
                journey.setIsCancelled(true);
            }
            if (departure.getPlatform() == null) {
                journey.setPlatform("");
            }
            else {
                journey.setPlatform(departure.getPlatform());
            }
            departuresList.add(journey);
        }
        return new JourneyBoard(departuresList);
    }
}