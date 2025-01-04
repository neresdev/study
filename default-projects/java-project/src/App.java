import java.util.UUID;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println(UUID.fromString("7396ac74384b4ae682a370aaaa5bb7ef"));
        System.out.println(UUID.randomUUID());
        var invalidUuid = "2db8119ae5d0404bb7f9829bcb6a51b5";
        var validUuid = convertToValidUUIDString(invalidUuid);
        int a = 0;
        // 7396ac74384b4ae682a370aaaa5bb7ef 
        // 2db8119a-e5d0-404b-b7f9-829bcb6a51b5
        // 8 13 18 23
    }

    private static String convertToValidUUIDString(String uuid){
        var validUuidString = new StringBuilder(uuid);
        validUuidString.insert(8, "-");
        validUuidString.insert(13, "-");
        validUuidString.insert(18, "-");
        validUuidString.insert(23, "-");

        return validUuidString.toString();
    }
}
