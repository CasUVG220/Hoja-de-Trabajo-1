import java.util.Scanner;

public class BasicBlender implements IBlender {

    private int speed; // Velocidad actual de la licuadora
    private boolean isFull; // Indica si la licuadora está llena

    public BasicBlender() {
        this.speed = 0; // Inicialmente apagada
        this.isFull = false; // Inicialmente vacía
    }

    // Incrementa la velocidad de la licuadora en 1
    @Override
    public void SpeedUp() {
        if (!isFull) {
            System.out.println("La licuadora está vacía. No se puede aumentar la velocidad.");
            return;
        }
        if (speed < 10) {
            speed++;
            System.out.println("Velocidad incrementada a: " + speed);
        } else {
            System.out.println("La velocidad ya está al máximo.");
        }
    }

    // Reduce la velocidad de la licuadora de forma gradual
    @Override
    public void SpeedDown() {
        if (speed > 0) {
            speed--;
            System.out.println("Velocidad reducida a: " + speed);
        } else {
            System.out.println("La licuadora ya está apagada.");
        }
    }

    // Llena la licuadora
    @Override
    public void Fill() {
        if (!isFull) {
            isFull = true;
            System.out.println("La licuadora ahora está llena.");
        } else {
            System.out.println("La licuadora ya está llena.");
        }
    }

    // Vacía la licuadora
    @Override
    public void Empty() {
        if (isFull) {
            isFull = false;
            speed = 0; // Resetea la velocidad al vaciar
            System.out.println("La licuadora ha sido vaciada.");
        } else {
            System.out.println("La licuadora ya está vacía.");
        }
    }

    // Verifica si la licuadora está llena
    @Override
    public boolean IsFull() {
        return isFull;
    }

    // Devuelve la velocidad actual
    @Override
    public int GetSpeed() {
        return speed;
    }

    public static void main(String[] args) {
        BasicBlender blender = new BasicBlender();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- Menú de la Licuadora ---");
            System.out.println("1. Prender la licuadora (Llenar)");
            System.out.println("2. Incrementar velocidad");
            System.out.println("3. Reducir velocidad");
            System.out.println("4. Consultar velocidad actual");
            System.out.println("5. Consultar si la licuadora está llena");
            System.out.println("6. Vaciar la licuadora");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    blender.Fill();
                    break;
                case 2:
                    blender.SpeedUp();
                    break;
                case 3:
                    blender.SpeedDown();
                    break;
                case 4:
                    System.out.println("Velocidad actual: " + blender.GetSpeed());
                    break;
                case 5:
                    System.out.println(blender.IsFull() ? "La licuadora está llena." : "La licuadora está vacía.");
                    break;
                case 6:
                    blender.Empty();
                    break;
                case 7:
                    System.out.println("Saliendo del programa. ¡Adiós!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (option != 7);

        scanner.close();
    }
}
