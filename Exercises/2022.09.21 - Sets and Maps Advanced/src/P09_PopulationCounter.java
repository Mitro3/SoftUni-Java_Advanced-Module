import java.util.*;

public class P09_PopulationCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, LinkedHashMap<String, Long>> countries = new LinkedHashMap();
        Map<String, Long> countriesTotalPopulation = new LinkedHashMap<>();

        while (!input.equals("report")) {
            String[] inputData = input.split("\\|");
            String currCity = inputData[0];
            String currCountry = inputData[1];
            long currPopulation = Long.parseLong(inputData[2]);

            if (!countries.containsKey(currCountry)) {
                LinkedHashMap<String, Long> currCityData = new LinkedHashMap();
                currCityData.put(currCity, currPopulation);
                countries.put(currCountry, currCityData);

                countriesTotalPopulation.put(currCountry, currPopulation);

            } else {
                LinkedHashMap<String, Long> currCountryData = countries.get(currCountry);
                currCountryData.put(currCity, currPopulation);
                countries.put(currCountry, currCountryData);

                long updatedPopulation = countriesTotalPopulation.get(currCountry) + currPopulation;
                countriesTotalPopulation.put(currCountry, updatedPopulation);

            }

            input = scanner.nextLine();
        }

        countries.entrySet().stream()
                .sorted((c1,c2)-> countriesTotalPopulation.get(c2.getKey()).compareTo(countriesTotalPopulation.get(c1.getKey())))
                .forEach(country ->{
                    System.out.format("%s (total population: %d)\n",country.getKey(),countriesTotalPopulation.get(country.getKey()));
                    country.getValue().entrySet()
                            .stream().sorted((t1,t2)-> t2.getValue().compareTo(t1.getValue())).forEach(city ->{
                                System.out.format("=>%s: %d\n", city.getKey(),city.getValue());
                            });
                });

    }
}
