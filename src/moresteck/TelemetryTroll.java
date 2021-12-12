package moresteck;

import java.util.Scanner;

public class TelemetryTroll {

    public static String javaVersion = "1.5.0_05";
    public static String platform = "Windows 95";
    public static String buildPlatform = "windows";
    public static String gameVersion = "a1.1.1";
    public static String gamemode = "survival";
    public static String serverType = "local";
    public static boolean modded = false;
    public static String accessToken = null;
    public static String clientId = null;
    public static String xuid = null;

    public static boolean running = true;

    public static void main(String[] args) {
        if (args.length > 0) {
            for (String s : args) {
                if (s == null) continue;

                if (s.toLowerCase().startsWith("gameversion=")) {
                    gameVersion = s.substring("gameversion=".length());
                } else if (s.toLowerCase().startsWith("platform=")) {
                    platform = s.substring("platform=".length());
                } else if (s.toLowerCase().startsWith("buildplatform=")) {
                    buildPlatform = s.substring("buildplatform=".length());
                } else if (s.toLowerCase().startsWith("gamemode=")) {
                    gamemode = s.substring("gamemode=".length());
                } else if (s.toLowerCase().startsWith("javaversion=")) {
                    javaVersion = s.substring("javaversion=".length());
                } else if (s.toLowerCase().startsWith("servertype=")) {
                    serverType = s.substring("servertype=".length());
                } else if (s.toLowerCase().startsWith("modded=")) {
                    modded = s.substring("modded=".length()).toLowerCase().equals("true");
                } else if (s.toLowerCase().startsWith("accesstoken=")) {
                    accessToken = s.substring("accesstoken=".length());
                } else if (s.toLowerCase().startsWith("xuid=")) {
                    xuid = s.substring("xuid=".length());
                } else if (s.toLowerCase().startsWith("clientid=")) {
                    clientId = s.substring("clientid=".length());
                }
            }
        }

        System.out.println("Welcome to MojangTelemetryTroll, the Mojang trolling software.");
        System.out.println("  To send some useless telemetry, type:");
        System.out.println("   send");
        System.out.println("  To exit this program, type:");
        System.out.println("   exit");
        System.out.println();
        System.out.println("  Flags:");
        System.out.println("   gameversion, platform, buildplatform, gamemode, javaversion, servertype, modded, accesstoken, clientid, xuid");
        System.out.println();

        Scanner scan = new Scanner(System.in);
        while (running) {
            if (scan.hasNextLine()) {
                String newline = scan.nextLine();

                if ("exit".equalsIgnoreCase(newline)) {
                    System.out.println("Exiting!");
                    scan.close();
                    running = false;
                    System.exit(0);
                    break;
                } else if ("send".equalsIgnoreCase(newline)) {
                    new TelemetryRequest().perform();
                    System.out.println("Telemetry sent!");
                }
            }
        }
    }
}
