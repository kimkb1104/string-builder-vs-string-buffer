public class Main {

    public static void main(String[] args) {

        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();

        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                stringBuffer.append(i);
                stringBuilder.append(i);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                stringBuffer.append(i);
                stringBuilder.append(i);
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(8000);

                System.out.println("stringBuffer.length() = " + stringBuffer.length());
                System.out.println("stringBuilder.length() = " + stringBuilder.length());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
