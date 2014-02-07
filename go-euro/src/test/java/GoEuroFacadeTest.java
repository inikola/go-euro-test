import org.goeuro.test.common.model.GoEuroRowConvertor;
import org.goeuro.test.common.model.csv.GoEuroRow;
import org.goeuro.test.common.model.exceptions.EmptyResultsExcpetion;
import org.goeuro.test.common.model.json.GeoPosition;
import org.goeuro.test.common.model.json.Result;
import org.goeuro.test.common.model.json.Results;
import org.goeuro.test.facade.GoEuroFacade;
import org.goeuro.test.services.CsvWriter;
import org.goeuro.test.services.GoEuroService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Test that the file is created or overwritten after the data being fetched from a Service.
 *
 * Created by Nikola.Ivanov on 2/7/14.
 */
public class GoEuroFacadeTest {


    private GoEuroFacade goEuroFacade;
    @Mock
    private CsvWriter csvWriter;
    @Mock
    private GoEuroService goEuroService;

    @Mock
    private GoEuroRowConvertor converter;
    private static final String QUERY = "Ri";

    private List<GoEuroRow> goEuroRowList;
    private Results results;


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);


        goEuroFacade = new GoEuroFacade(goEuroService,csvWriter,converter);

        initResults();
        initGoEuroRows();
    }

    @Test
    public void testSaveResults(){

        List<Result> resultList = results.getResults();
        when(goEuroService.getResultsPositions(QUERY)).thenReturn(results);
        when(converter.convertFromList(resultList)).thenReturn(goEuroRowList);

        goEuroFacade.saveResults(QUERY);

        verify(csvWriter).writeRowsToFile(goEuroRowList);
    }

    @Test(expected = EmptyResultsExcpetion.class)
    public void testSaveResults_EmptyResults(){
        List<Result> resultList = new ArrayList<Result>();
        results.setResults(resultList);
        when(goEuroService.getResultsPositions(QUERY)).thenReturn(results);

        goEuroFacade.saveResults(QUERY);
    }


    private void initGoEuroRows(){
        goEuroRowList = new GoEuroRowConvertor().convertFromList(results.getResults());
    }


    private void initResults(){
        results = new Results();
        List<Result> resultList = new ArrayList<Result>();
        Result result1 = new Result();
        Result result2 = new Result();

        result1.set_id(123214);
        result1.setName("Riga");
        result1.set_type("Position");
        result1.setType("location");
        GeoPosition geoPosition = new GeoPosition();
        geoPosition.setLongitude(32.21);
        geoPosition.setLatitude(44.22);
        result1.setGeoPosition(geoPosition);

        result2.setType("location");
        result2.set_id(124341);
        result2.setName("Rio");
        result2.set_type("Position");
        GeoPosition geoPosition1 = new GeoPosition();
        geoPosition.setLatitude(43.32);
        geoPosition.setLongitude(32.432);
        result2.setGeoPosition(geoPosition);
        resultList.add(result1);
        resultList.add(result2);

        results.setResults(resultList);
    }




}
