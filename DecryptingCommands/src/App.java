import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
 
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Integer> animals = new LinkedHashMap<>();
        Map<String, Integer> areas = new LinkedHashMap<>();
        Map<String, String> animalsToArea = new LinkedHashMap<>();
        
        while (!input.equals("EndDay")) {
            String[] tokens = input.split(": ");
            String command = tokens[0];
            String[] commandTokens = tokens[1].split("-");
            String animalName = commandTokens[0];
            String area = commandTokens[2];
            
            switch (command) {
                case "Add":
                    int food = Integer.parseInt(commandTokens[1]);
                    animals.putIfAbsent(animalName, 0);
                    animals.put(animalName, animals.get(animalName) + food);
                    areas.putIfAbsent(area, 0);
                    areas.put(area, areas.get(area) + 1);
                    animalsToArea.putIfAbsent(animalName, area);
                    break;
                case "Feed":
                    int foodToFeed = Integer.parseInt(commandTokens[1]);
                    if (animals.containsKey(animalName)) {
                        animals.put(animalName, animals.get(animalName) - foodToFeed);
                        if (animals.get(animalName) <= 0) {
                            animals.remove(animalName);
                            areas.put(area, areas.get(area) - 1);
                            System.out.println(animalName + " was successfully fed");
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        System.out.println("Animals:");
        animals.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue())).forEach(a -> System.out.println(" " + a.getKey() + " -> " + a.getValue() + "g"));
        System.out.println("Areas with hungry animals:");
        areas.entrySet().stream().filter(a -> a.getValue() > 0).sorted((a, b) -> b.getValue().compareTo(a.getValue())).forEach(a -> System.out.println(" " + a.getKey() + ": " + a.getValue()));

        scanner.close();
    }
}

/*
Create a java program that organizes the daily feeding of the animals at the zoo. You need to keep information about animals, their daily food limit, and the areas they live in. You will be receiving lines with commands until you receive the "EndDay" message. There are two possible commands:  
• "Add: {animal_name}-{needed_food_quantity}-{area}": 
o Add the animal and the quantity of needed food to your records. It is guaranteed that the names of the animals are unique, and there will never be animals with the same name.  
o If the animal already exists, just increase the value of its needed food with the given one. o You should keep track of the animal living in each area. 
• "Feed: {animalName}-{food}": 
o If the animal exists, reduce its quantity of needed food with the given food for feeding. 
o If the animal does not exist, ignore the command. 
o If its limit reaches 0 or less, the animal is considered successfully fed, and you need to remove it from your records and print the following message: ▪ "{animalName} was successfully fed"

You need to know the number of hungry animals there are left in each area. If an animal has a daily food limit above 0, it is considered hungry. In the end, you should print each animal with its quantity of needed food in the following format:  "Animals:" " {animal_name} -> {needed_food_quantity}g" ... " {animal_name} -> {needed_food_quantity}g" Afterward, print only the areas with hungry animals in the following format: "Areas with hungry animals:" " {area_name}: {number_of_hungry_animals}" ... " {area_name}: {number_of_hungry_animals}" 

Input / Constraints 
• You will be receiving lines until you receive the "EndDay" command. 
• The food comes in grams and is an integer number in the range [1...100000]. 
• The input will always be valid. 
• There will never be a case in which an animal is in two or more areas at the same time. 

Output 
• Print the appropriate message after the "Feed" command if an animal is fed. 
• Print the animals with their quantity of needed food in the format described above. 
• Print the areas with the number of hungry animals in them in the format described above.

Example: 
Input:
Add: Adam-4500-ByTheCreek
Add: Maya-7600-WaterfallArea
Add: Maya-1230-WaterfallArea
Feed: Jamie-2000
EndDay

Output: 
Animals:
 Adam -> 4500g
 Maya -> 8830g
Areas with hungry animals:
 ByTheCreek: 1
 WaterfallArea: 1

 Use LinkedHashMap to keep the order of the input
*/