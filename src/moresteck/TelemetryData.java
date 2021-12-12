package moresteck;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class TelemetryData {

    public String UserId = null;
    public String ClientId = null;
    public String deviceSessionId = UUID.randomUUID().toString();
    public String WorldSessionId = UUID.randomUUID().toString();
    public String eventTimestampUtc = DateTimeFormatter.ISO_OFFSET_DATE_TIME.withZone(ZoneId.from(ZoneOffset.UTC)).format(Instant.now());
    public String build_display_name;
    public String server_type;
    public String BuildPlat;
    public String Plat;
    public String javaVersion;
    public String PlayerGameMode;
    public boolean clientModded;

    public TelemetryData(String gamever, String type, String buildplat, String plat, String javaver, String gamemode, boolean modded, String xuid, String clientid) {
        this.build_display_name = gamever;
        this.server_type = type;
        this.BuildPlat = buildplat;
        this.Plat = plat;
        this.javaVersion = javaver;
        this.PlayerGameMode = gamemode;
        this.clientModded = modded;

        this.UserId = xuid;
        this.ClientId = clientid;
    }
}
