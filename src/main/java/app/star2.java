package app;

public class star2 {
    public static void main(String[] args) {
    int width = 50;
    int height = 10;
    double k = ((double) width)/height;
    StringBuilder envelope = new StringBuilder();
    for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
            if (x == 0 ||
                    x == width - 1 ||
                    y == 0 ||
                    y == height -1 ||
                    x == y * k ||
                    width - x - 1 == y * k
            ) {
                envelope.append("*");

            } else {
                envelope.append(" ");

            }
        }

        envelope.append("\n");
    }

    System.out.println(envelope);
}
}
