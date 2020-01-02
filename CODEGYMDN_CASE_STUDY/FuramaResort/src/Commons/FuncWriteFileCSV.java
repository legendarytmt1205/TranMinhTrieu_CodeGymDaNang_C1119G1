package Commons;

import Models.Villa;

import java.util.ArrayList;


public class FuncWriteFileCSV {
    private static final char DEFAULT_COMMA = ',';
    private static final char DEFAULT_QUOTE = '"';
    private static final String path = "src/Data";
    private static String[] headerVilla = new String[]{"id","nameServices","areaUsed"
                                                         ,"numberOfPeople","typeRent","roomStandard"
                                                         ,"areaPool","utilities","utilities"};
    public static void writeVillaCSV(ArrayList<Villa>arrayList) {

    }
}
