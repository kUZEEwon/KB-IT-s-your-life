import com.mongodb.client.*;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class MainClass {
    public static void main(String[] args) {

        String URI = "mongodb://localhost:27017";
        String DATABASE = "mydb";

        try (MongoClient mongoClient = MongoClients.create(URI)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE);

            // collection(table) 선택
            String COLLECTION = "employees";
            MongoCollection<Document> collection = database.getCollection(COLLECTION);
/*
            // 다수의 문서 삽입
            List<Document> employees = new ArrayList<>();
            Document doc1 = new Document();
            Document doc2 = new Document();

            doc1.append("employee_id", 112);
            doc1.append("first_name", "NASHO");
            doc1.append("age", 17);

            doc2.append("employee_id", 123);
            doc2.append("first_name", "KOILA");
            doc2.append("age", 26);

            employees.add(doc1);
            employees.add(doc2);
            collection.insertMany(employees);*/

            // 데이터 조회 예제
            // 하나
           /* Document documentOne = collection.find(new Document("employee_id", 105)).first();
            System.out.println(documentOne);
            System.out.println("------------------------------------------");

            Document query = new Document("employee_id", 105); // 예를 들어 employee_id가 105인 문서를 조회
            FindIterable<Document> result = collection.find(query);

            for (Document document : result) {
                System.out.println(document.toJson());
            }*/

            // update 변경하려는 document
           /* Bson q = eq("employee_id", 105);
            // 수정하려는 데이터
            Bson updates= Updates.combine(Updates.set("first_name", "Gang"), Updates.set("age",35));
            // 적용
            UpdateResult updateResult = collection.updateOne(q, updates); // updateMany 도 있음
            System.out.println(updateResult.getModifiedCount());*/



            // delete
            Bson query = eq("first_name", "KOILA");
            DeleteResult deleteResult = collection.deleteOne(query);
            System.out.println(deleteResult.getDeletedCount());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
