import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Created by 014516 on 5/1/2019.
 */
public class Main {
    public static void main(String[] args) {
        serializeSimple();
        deserializeSimple();
    }

    static void serializeSimple() {
        Simple person1 = new Simple("Walk the dog",false,0,3,"Dog");
        Simple person2 = new Simple("Pay the bills",false,1,1,"bills");
        ArrayList <Simple> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);
        Gson gson = new Gson();
        String json = gson.toJson(person1);
        String json2 = gson.toJson(person2);
        try {
            FileWriter writer = new FileWriter("serialize.json");
            gson.toJson(list, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    static void deserializeSimple() {
        String jsonPerson1 = "{\"body\":\"Walk the dog\",\"done\":\"false\",\"id\":0,\"priority\":3,\"title\":\"dog\"}";
        String jsonPerson2 = "{\"body\":\"Pay the bills\",\"done\":\"false\",\"id\":1,\"priority\":1,\"title\":\"bills\"}";
        JsonParser parser = new JsonParser();
        JsonElement test1 = parser.parse(jsonPerson1);
        JsonElement test2 = parser.parse(jsonPerson2);
        System.out.println(test1.isJsonObject());
        System.out.println(test2.isJsonObject());

        Gson gson = new Gson();
        Simple person1 = gson.fromJson(jsonPerson1, Simple.class);
        Simple person2 = gson.fromJson(jsonPerson2, Simple.class);
        System.out.println(person1.toString());
        System.out.println(person2.toString());

    }
}
    class Simple {
        private String body;
        private boolean done;
        private int id;
        private int priority;
        private String title;

        public Simple(String body, boolean done, int id, int priority, String title) {
            this.body = body;
            this.done = done;
            this.id = id;
            this.priority = priority;
            this.title = title;
        }

        @Override
        public String toString() {
            return "Simple{" +
                    "body='" + body + '\'' +
                    ", done=" + done +
                    ", id=" + id +
                    ", priority=" + priority +
                    ", title='" + title + '\'' +
                    '}';
        }
    }
