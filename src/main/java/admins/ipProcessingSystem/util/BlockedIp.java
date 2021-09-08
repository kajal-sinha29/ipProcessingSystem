package admins.ipProcessingSystem.util;

import java.util.ArrayList;

public class BlockedIp {

  public static ArrayList<String> ipList = new ArrayList<>();

    public ArrayList<String> blockedByAdmin(){

        ipList.add("ipFirst");
        ipList.add("ip2");
        ipList.add("ip3");
        ipList.add("ip4");
        ipList.add("ip5");
        ipList.add("ip6");
        ipList.add("ip7");
        ipList.add("ip8");
        ipList.add("ip9");
        ipList.add("ip10");

        return ipList;
    }
}
