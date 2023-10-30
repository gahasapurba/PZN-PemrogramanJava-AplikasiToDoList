public class AplikasiToDoList {

    public static String[] model = new String[10];

    public static void main(String[] args) {

        testShowToDoList();

    }

    /**
     * Menampilkan ToDoList
     */
    public static void showToDoList(){

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

    /**
     * Menghapus ToDoList
     */
    public static void removeToDoList(){

    }

    /**
     * Menampilkan View ToDoList
     */
    public static void viewShowToDoList(){

    }

    /**
     * Menampilkan View Menambah ToDoList
     */
    public static void viewAddToDoList(){

    }

    /**
     * Menampilkan View Menghapus ToDoList
     */
    public static void viewRemoveToDoList(){

    }

}