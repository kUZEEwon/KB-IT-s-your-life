public class ObjectFactory {
    // 사용자 입력에 따라 적절한 객체를 생성하고 반환
    public static Object createObject(String type) {
        switch (type.toLowerCase()) {
            case "apple":
                return new AppleClass();
            case "banana":
                return new BananaClass();
            case "ice":
                return new IceClass();

            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
    }

}

