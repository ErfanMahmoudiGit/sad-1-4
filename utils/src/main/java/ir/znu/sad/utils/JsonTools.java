package ir.znu.sad.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public final class JsonTools {

    private JsonTools(){};

    private static Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();
    private static Gson gsonSimple = new Gson();

    public static String toJson(Object src){
        return gsonSimple.toJson(src);
    }

    public static <T> T fromJson(String json, Class<T> classOfT){
        return gsonSimple.fromJson(json,classOfT);
    }
    public static <T> T fromJson(String json, TypeToken<T> typeToken) {
        return gsonSimple.fromJson(json, typeToken.getType());
    }

    public static final String getPretty(String json){
        JsonElement je = JsonParser.parseString(json);
        String prettyJsonString = gsonPretty.toJson(je);
        return prettyJsonString;
    }

}
