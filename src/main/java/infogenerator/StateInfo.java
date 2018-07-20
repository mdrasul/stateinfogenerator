package infogenerator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StateInfo 
{

    public final String state_abbr;
    public  final String state_largest_city;
    public final String State_Capital;

    public static final Map<String, StateInfo> statesByName = new HashMap<String, StateInfo>();
    public static final Map<String, StateInfo> statesByAbbreviation = new HashMap<String, StateInfo>();


    static {
        String[][] stateInformation = new String[][] {
            {"Alabama", "Yellowhammer", "Camelia"},
            {"Alaska", "Willow Ptarmigan", "Forget-Me-Not"},
            {"Arizona", "Cactus Wren", "Saguaro Cactus Blossom"},
            {"Arkansas", "Mockingbird", "Apple Blossom"},
            {"California", "California Valley Quail", "Golden Poppy"},
            {"Colorado", "Lark Bunting", "Rocky Mountain Columbine"},
            {"Connecticut", "Robin", "Mountain Laurel"},
            {"Delaware", "Blue Hen Chicken", "Peach Blossom"},
            {"Florida", "Mockingbird", "Orange Blossom"},
            {"Georgia", "Brown Thrasher", "Cherokee Rose"},
            {"Hawaii", "Nene", "Hawaiian Hibiscus"},
            {"Idaho", "Mountain Bluebird", "Syringa, mock orange"},
            {"Illinois", "Cardinal", "Violet"},
            {"Indiana", "Cardinal", "Peony"},
            {"Iowa", "Eastern Goldfinch", "Wild Praire Rose"},
            {"Kansas", "Western Meadowlark", "Sunflower"},
            {"Kentucky", "Cardinal", "Goldenrod"},           
            {"Louisiana", "Eastern Brown Pelican", "Magnolia"},
            {"Maine", "Chickadee", "Pine Cone and Tassel"},
            {"Maryland", "Baltimore Oriole", "Black-Eyed Susan"},
            {"Massachusetts", "Chickadee", "Mayflower"},
            {"Michigan", "Robin", "Apple Blossom"},
            {"Minnesota", "Common Loon", "Pink and White Lady's Slippper"},
            {"Mississippi", "Mockingbird", "Magnolia"},
            {"Missouri", "Bluebird", "Hawthorn"},
            {"Montana", "Western Meadowlark", "Bitterroot"},
            {"Nebraska", "Western Meadowlark", "Goldenrod"},
            {"Nevada", "Mountain Bluebird", "Sagebrush"},
            {"New Hampshire", "Purple Finch", "Purple Lilac"},
            {"New Jersey", "Eastern Goldfinch", "Violet"},
            {"New Mexico", "Roadrunner", "Yucca Flower"},
            {"NewYork", "Bluebird", "Rose"},
            {"North Carolina", "Cardinal", "Flowering Dogwood"},
            {"North Dakota", "Western Meadowlark", "Wild Praire Rose"},
            {"Ohio", "Cardinal", "Scarlet Carnation"},
            {"Oklahoma","Scissor-tailed Flycatcher","Oklahoma Rose"},            
            {"Oregon", "Western Meadowlark", "Oregon Grape"},
            {"Pennsylvania", "Ruffed Grouse", "Mountain Laurel"},
            {"Rhode Island", "Rhode Island Red", "Violet"},           
            {"South Carolina", "Great Carolina Wren", "Yellow Jessamine"},
            {"South Dakota", "Ring-necked Pheasant", "Pasque Flower"},
            {"Tennessee", "Mockingbird", "Purple Passionflower"},
            {"Texas", "Mockingbird", "Bluebonnet Sp."},
            {"Utah", "Common American Gull", "Sego Lily"},
            {"Vermont", "Hermit Thrush", "Red Clover"},
            {"Virginia","Cardinal"," American Dogwood"},
            {"Washington", "Willow Goldfinch", "Coast Rhododendrum"},
            {"West Virginia", "Cardinal", "Rhododendron"},
            {"Wisconsin", "Robin", "Wood Violet"},
            {"Wyoming", "Western Meadowlark", "Indian Paintbrush"}
        };

        for (String[] info : stateInformation) 
        {
        		statesByName.put(info[0].toLowerCase(), new StateInfo(info[0], info[1], info[2]));
        }
    }

    

    public StateInfo(String state_abbr, String state_largest_city, String State_Capital) 
    {
        this.state_abbr = state_abbr;
        this.state_largest_city = state_largest_city;
        this.State_Capital = State_Capital;
    }

    public static StateInfo getInfo(String stateName) 
    {
        return statesByName.get(stateName.toLowerCase());
    }
    
    public static StateInfo getInfoByabbreviation(String stateName) 
    {
        return statesByAbbreviation.get(stateName.toLowerCase());
    }

    public static void main(String[] args) 
    {

        Scanner userInput = new Scanner(System.in);

        while (true) 
        {
            System.out.println("Enter a State or None to exit:");
            String stateName = userInput.next();

            if (stateName.equalsIgnoreCase("None")) 
            {
                break;
            } 
            else 
            {
                StateInfo stateInfo = getInfo(stateName);
                if (stateInfo != null) 
                {
                    System.out.println("State abbreviation: " + stateInfo.state_abbr);
                    System.out.println("State largest_city: " + stateInfo.state_largest_city);
                    System.out.println("State Capital: " + stateInfo.State_Capital);
                } 
                else 
                {
                    System.out.println("Invalid State Entered");
                }
            }
        }
    }

    

}