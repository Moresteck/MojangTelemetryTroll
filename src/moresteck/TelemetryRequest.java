package moresteck;

import java.time.Instant;

import com.google.gson.Gson;

import moresteck.util.Request;
import moresteck.util.RequestUtil;
import moresteck.util.Response;

public class TelemetryRequest extends Request {
    public String source = "minecraft.java";
    public String name = "WorldLoaded";
    public long timestamp = Instant.now().getEpochSecond();
    public TelemetryData data = null;

    public TelemetryRequest() {
        this.REQUEST_URL = "https://api.minecraftservices.com/events";

        this.data = new TelemetryData(
                TelemetryTroll.gameVersion,
                TelemetryTroll.serverType,
                TelemetryTroll.buildPlatform,
                TelemetryTroll.platform,
                TelemetryTroll.javaVersion,
                TelemetryTroll.gamemode,
                TelemetryTroll.modded,
                TelemetryTroll.xuid,
                TelemetryTroll.clientId
        );

        this.PROPERTIES.put("Content-Type", "application/json; charset=utf-8");
        this.PROPERTIES.put("Authorization", "Bearer " + TelemetryTroll.accessToken);

        Gson gson = new Gson();
        try {
            this.PROPERTIES.put("Content-Length", Integer.toString(gson.toJson(this).getBytes("UTF-8").length));
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public Response perform() {
        RequestUtil.performPOSTRequest(this);
        return null;
    }
}
