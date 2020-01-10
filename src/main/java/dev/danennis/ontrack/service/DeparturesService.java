package dev.danennis.ontrack.service;

import com.thalesgroup.rtti._2013_11_28.token.types.AccessToken;
import com.thalesgroup.rtti._2017_10_01.ldb.GetBoardRequestParams;
import com.thalesgroup.rtti._2017_10_01.ldb.LDBServiceSoap;
import com.thalesgroup.rtti._2017_10_01.ldb.Ldb;
import com.thalesgroup.rtti._2017_10_01.ldb.StationBoardWithDetailsResponseType;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ServiceItemWithCallingPoints;
import dev.danennis.ontrack.model.Departure;
import dev.danennis.ontrack.model.DepartureBoard;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DeparturesService {
    public DepartureBoard getDepartures(String CRS, int responseLength) {
        AccessToken accessToken = new AccessToken();
        accessToken.setTokenValue("1a372d9f-307e-4016-93c5-6cbfd3d52336");
        GetBoardRequestParams parameters = new GetBoardRequestParams();
        parameters.setCrs(CRS);
        parameters.setNumRows(responseLength);
        LDBServiceSoap LDBService = new Ldb().getLDBServiceSoap12();
        StationBoardWithDetailsResponseType departuresBoard = LDBService.getDepBoardWithDetails(parameters, accessToken);
        return convertToJSON(departuresBoard);
    }
    public DepartureBoard convertToJSON(StationBoardWithDetailsResponseType departuresBoard) {
        List<ServiceItemWithCallingPoints> departures = departuresBoard.getGetStationBoardResult().getTrainServices().getService();
        List<Departure> departureList = new ArrayList();
        for (ServiceItemWithCallingPoints departure: departures) {
            Departure departureTrain = new Departure();
            departureTrain.setArrivalCrs(departure.getDestination().getLocation().get(0).getCrs());
            departureTrain.setCancelled(departure.isIsCancelled() != null ? departure.isIsCancelled() : false);
            departureTrain.setEstimatedDepartureTime(departure.getEtd());
            departureTrain.setArrivalName(departure.getDestination().getLocation().get(0).getLocationName());
            departureTrain.setPlatform(departure.getPlatform());
            departureTrain.setScheduledDepartureTime(departure.getStd());
            departureList.add(departureTrain);
        }
        DepartureBoard board = new DepartureBoard(departuresBoard.getGetStationBoardResult().getLocationName(), departureList);
        return board;
    }
}