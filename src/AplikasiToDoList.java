public class AplikasiToDoList {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        testViewRemoveToDoList();

    }

    /**
     * Menampilkan ToDoList
     */
    public static void showToDoList(){

        System.out.println("TO DO LIST");

        for (var i = 0 ; i < model.length ; i++) {
            var todo = model[i];
            var no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo);
            }
        }

    }

    public static void testShowToDoList() {
        model[0] = "Belajar Java Dasar";
        model[1] = "Studi Kasus Java Dasar : Aplikasi ToDoList";

        showToDoList();
    }

    /**
     * Menambah ToDoList
     */
    public static void addToDoList(String todo){
        // Cek Apakah Model Penuh?
        var isFull =true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                // Model Masih Ada Yang Kosong
                isFull = false;
                break;
            }
        }

        // Jika Penuh, Kita Resize Ukuran Array 2X Lipat
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        // Tambahkan Ke Posisi Yang Data Array Nya Null
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddToDoList() {
        for (int i = 0; i < 25; i++) {
            addToDoList("Contoh ToDo Ke " + i);
        }

        showToDoList();
    }

    /**
     * Menghapus ToDoList
     */
    public static boolean removeToDoList(Integer number){
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveToDoList() {
        addToDoList("Satu");
        addToDoList("Dua");
        addToDoList("Tiga");
        addToDoList("Empat");
        addToDoList("Lima");

        var result = removeToDoList(20);
        System.out.println(result);

        result = removeToDoList(7);
        System.out.println(result);

        result = removeToDoList(2);
        System.out.println(result);

        showToDoList();
    }

    /**
     * Menerima Input
     */

    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput() {
        var name = input("Nama");
        System.out.println("Hi " + name);

        var channel = input("Channel");
        System.out.println(channel);
    }

    /**
     * Menampilkan View ToDoList
     */
    public static void viewShowToDoList(){
        while (true) {
            showToDoList();

            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Tambah");
            System.out.println("x. Tambah");

            var input = input("Pilih");

            if (input.equals("1")) {
                viewAddToDoList();
            } else if (input.equals("2")) {
                viewRemoveToDoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan Tidak Dimengerti");
            }
        }
    }

    public static void testViewShowToDoList(){
        addToDoList("Satu");
        addToDoList("Dua");
        addToDoList("Tiga");
        addToDoList("Empat");
        addToDoList("Lima");
        viewShowToDoList();
    }

    /**
     * Menampilkan View Menambah ToDoList
     */
    public static void viewAddToDoList(){
        System.out.println("MENAMBAH TO DO LIST");

        var todo = input("ToDo (x Jika Batal)");

        if (todo.equals("x")) {
            // Batal
        } else {
            addToDoList(todo);
        }
    }

    public static void testViewAddToDoList(){
        addToDoList("Satu");
        addToDoList("Dua");

        viewAddToDoList();

        showToDoList();
    }

    /**
     * Menampilkan View Menghapus ToDoList
     */
    public static void viewRemoveToDoList(){
        System.out.println("MENGHAPUS TO DO LIST");

        var number = input("Nomor Yang Hendak Dihapus (x Jika Batal)");

        if (number.equals("x")) {
            // Batal
        } else {
            boolean success = removeToDoList(Integer.valueOf(number));
            if (!success) {
                System.out.println("Gagal Menghapus ToDoList : " + number);
            }
        }
    }

    public static void testViewRemoveToDoList(){
        addToDoList("Satu");
        addToDoList("Dua");
        addToDoList("Tiga");

        showToDoList();

        viewRemoveToDoList();

        showToDoList();
    }

}