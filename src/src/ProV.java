import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ProV {

    Scanner in = new Scanner(System.in);
    String secim1;
    String secim2;
    String secim3;
    String secim4;
    String secim5;
    boolean bln1 = false;
    boolean bln2 = false;
    boolean bln3 = false;
    boolean bln4 = false;
    boolean bln5 = false;
    boolean bln6 = false;

    public ProV() {
        try {

            File Fayl = new File("src/src/Fayl.txt");

            Fayl.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Menu();
    }

    public void Menu() {
        Clear();
        System.out.println("     MENU\n \n1 - Giris edin\n2 - Qeydiyyat\n0 - Cixis\n");
        if (bln2) {
            System.out.print("Dogru secim edin!!!: ");
            bln2 = false;
        } else {
            System.out.print("Secim edin: ");
        }
        secim1 = in.nextLine();
        SW(secim1);
    }

    public void SW(String a1) {
        switch (a1) {
            case "1":
                giris();
                break;
            case "2":
                qeydiyyat();
                break;
            case "0":
                Exit();
                break;
            default:
                bln2 = true;
                Menu();
                break;
        }
    }

    public void giris() {
        Clear();
        if (bln1) {
            System.out.print("Email yada sifre yanlisdir yeniden daxil edin!!!: ");
            bln1 = false;
        } else {
            System.out.print("Email daxil edin: ");
        }
        secim4 = in.nextLine().trim();

        Clear();
        System.out.print("Sifreni daxil edin: ");
        secim5 = in.nextLine().trim();

        try {
            File vs = new File("src/src/Fayl.txt");
            Scanner vs2 = new Scanner(vs);
            boolean found = false;

            while (vs2.hasNextLine()) {
                String data = vs2.nextLine().trim();
                String[] list = data.split(";");

                if (list.length == 3) {
                    String email = list[1].trim();
                    String sifre = list[2].trim();

                    if (secim4.equals(email) && secim5.equals(sifre)) {
                        Clear();
                        System.out.print(list[0]);
                        found = true;
                        break;
                    }
                }
            }

            vs2.close();

            if (found) {
                sistemeGiris();
            } else {
                bln1 = true;
                giris();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*
     * public void giris2() {
     * Clear();
     * if (bln5) {
     * System.out.print("Sifre yanlisdir!!!: ");
     * bln5 = false;
     * } else {
     * System.out.print("Sifreni daxil edin: ");
     * }
     * secim5 = in.nextLine();
     * try {
     *
     * File vs = new File("src/src/Fayl.txt");
     * Scanner vs2 = new Scanner(vs);
     *
     * while (vs2.hasNextLine()) {
     * String data = vs2.nextLine();
     * String[] list = data.split(";");
     * String sifre = list[2];
     * if (secim5.equals(sifre))
     * sistemeGiris();
     * }
     *
     * bln5 = true;
     * giris2();
     * vs2.close();
     *
     * } catch (FileNotFoundException e) {
     * e.printStackTrace();
     * }
     * }
     */

    public void sistemeGiris() {
        // Clear();
        System.out.println(" - Sisteme Xos Geldiniz *_*\n");
    }

    public void qeydiyyat() {
        Clear();
        if (bln5) {
            System.out.print("Bu ad sistemde var ferqli ad daxil edin!!!: ");
            bln5 = false;
        } else {
            System.out.print("Tam adinizi daxil edin: ");
        }

        try {

            FileWriter vs = new FileWriter("src/src/Fayl.txt", true);
            String input = in.nextLine();

            File vs1 = new File("src/src/Fayl.txt");
            Scanner vs2 = new Scanner(vs1);

            while (vs2.hasNextLine()) {
                String data = vs2.nextLine().trim();
                String[] list = data.split(";");

                if (list.length == 3) {
                    String tamad = list[0].trim();

                    if (input.equals(tamad)) {
                        bln5 = true;
                        qeydiyyat();
                    }
                }
            }

            vs2.close();

            vs.write(input);
            vs.write(";");

            vs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        qeydiyyat2();
    }

    public void qeydiyyat2() {
        Clear();
        if (bln6) {
            System.out.print("Bu email sistemde var ferqli email daxil edin!!!: ");
            bln6 = false;
        } else {
            System.out.print("Email daxil edin: ");
        }
        try {
            FileWriter vs = new FileWriter("src/src/Fayl.txt", true);
            String input2 = in.nextLine();

            File vs1 = new File("src/src/Fayl.txt");
            Scanner vs2 = new Scanner(vs1);

            while (vs2.hasNextLine()) {
                String data = vs2.nextLine().trim();
                String[] list = data.split(";");

                if (list.length == 3) {
                    String email = list[1].trim();

                    if (input2.equals(email)) {
                        bln6 = true;
                        qeydiyyat2();
                    }
                }
            }

            vs.write(input2);
            vs.write(";");

            vs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        qeydiyyat3();
    }

    public void qeydiyyat3() {
        Clear();
        if (bln6) {
            System.out.print("Bu sifre sistemde var ferqli sifre daxil edin!!!: ");
            bln6 = false;
        } else {
            System.out.print("Sifre teyin edin: ");
        }
        try {
            FileWriter vs = new FileWriter("src/src/Fayl.txt", true);
            String input3 = in.nextLine();

            File vs1 = new File("src/src/Fayl.txt");
            Scanner vs2 = new Scanner(vs1);

            while (vs2.hasNextLine()) {
                String data = vs2.nextLine().trim();
                String[] list = data.split(";");

                if (list.length == 3) {
                    String sifre = list[2].trim();

                    if (input3.equals(sifre)) {
                        bln6 = true;
                        qeydiyyat3();
                    }
                }
            }

            vs.write(input3);
            vs.write("\n");

            vs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ugurluQeydiyyat();
    }

    public void ugurluQeydiyyat() {
        Clear();
        System.out.println("Qeydiyyatdan ugurla kecdiniz\n\n");
        System.out.println("1 - Menu\n0 - Cixis\n\n");
        if (bln3) {
            System.out.print("Dogru secim edin!!!: ");
            bln3 = false;
        } else {
            System.out.print("Secim edin: ");
        }
        secim2 = in.nextLine();
        SW2(secim2);
    }

    public void SW2(String a1) {
        switch (a1) {
            case "1":
                Menu();
                break;
            case "0":
                Exit();
                break;
            default:
                bln3 = true;
                ugurluQeydiyyat();
                break;
        }
    }

    public void Exit() {
        Clear();
        System.out.println("Cixis etmek isteyirsinizmi?");
        System.out.println("    1 - He     2 - Yox");
        if (bln4) {
            System.out.print("Dogru secim edin!!!: ");
            bln4 = false;
        } else {
            System.out.print("Secim edin: ");
        }
        secim3 = in.nextLine();
        SW3(secim3);
    }

    public void SW3(String a1) {
        switch (a1) {
            case "1":
                End();
                break;
            case "2":
                Menu();
                break;
            default:
                bln4 = true;
                Exit();
                break;
        }
    }

    public void End() {
        Clear();
        System.out.println("Cixis edildi...");
    }

    public void Clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
