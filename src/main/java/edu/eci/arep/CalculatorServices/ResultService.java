package edu.eci.arep.CalculatorServices;

import edu.eci.arep.Entities.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Result Service class represents the services of the result.
 *
 * @author Carlos Medina
 */
public class ResultService {

    private AtomicInteger count;
    private Map<Integer, Result> results;

    public ResultService() {
        count = new AtomicInteger(0);
        results = new HashMap<>();
    }

    public void addResult(Result result) {
        count.addAndGet(1);
        results.put(count.get(), result);
    }

    public Result getResultById(int id) {
        Result ans = null;
        if (results.containsKey(id)) {
            ans = results.get(id);
        }
        return ans;
    }

    public List<Result> getAllResults() {
        List<Result> resultsGet = new ArrayList<>();
        for (int id : results.keySet()) {
            resultsGet.add(results.get(id));
        }
        return resultsGet;
    }

    public int getMaxId() {
        return count.get();
    }
}
