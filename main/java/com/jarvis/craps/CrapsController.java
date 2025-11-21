package com.jarvis.craps;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrapsController {

    private final CrapsService service = new CrapsService();

    @GetMapping("/craps")
    public CrapsResponse runCraps() {
        int[] results = service.rollDice();
        int[] sorted = service.sortResults(results);
        double[] probs = service.getProbabilities(results);

        return new CrapsResponse(results, sorted, probs);
    }

    public record CrapsResponse(int[] results, int[] sortedResults, double[] probabilities) {}
}
