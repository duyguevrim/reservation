package reservation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Reservation {


    public static void main(String[] args) throws FileNotFoundException, IOException {

        String[] gecici = new String[8000];
        String gecicicat;
        Scanner scan = new Scanner(System.in);
        String file = "rezervasyon.csv";
        FileReader fileReader = new FileReader(file);
        String line;

        BufferedReader br = new BufferedReader(fileReader);
        String[][] deneme2 = new String[8000][7];
        String[][] deneme3 = new String[8000][7];
        int i = 0;
        while ((line = br.readLine()) != null) {
            line = line.replace("\"", "");

            String[] temp = line.split(",");
            deneme2[i] = temp;
            i++;
            System.out.println(line);

        }

        String[] name = new String[8000];
        String[] category = new String[8000];
        int sayac = 1;
        String[] namecat = new String[8000];
        String[] altcategori = new String[8000];
        String[] placeid = new String[8000];
        String[] datetime = new String[8000];
        String[] enlem = new String[8000];
        String[] boylam = new String[8000];
        String[] city = new String[8000];

        for (i = 0; i < 8000; i++) {

            namecat[i] = deneme2[i][0] + " " + deneme2[i][6];
            String kelime = deneme2[i][6];
            name[i] = deneme2[i][0];
            category[i] = deneme2[i][6];
            placeid[i] = deneme2[i][1];
            datetime[i] = deneme2[i][2];
            enlem[i] = deneme2[i][3];
            boylam[i] = deneme2[i][4];
            city[i] = deneme2[i][5];

        }


        System.out.println("Seciminizi giriniz:\n 1-Kullaniciya gore kategori bulma \n 2-Kategoriye gore kullanici bulma \n 3-Rezervasyon yerine gore kullanici listeleme \n 4-Kullaniciya gore rezervasyon listeleme\n 5-Kategori Bilgileri");
        int secim = scan.nextInt();
        scan.nextLine();
        switch (secim) {

            case 1:

                int x = -1;
                String control = "evet";
                while (control.equals("evet")) {
                    x++;
                    System.out.println("kullanici adi giriniz: ");
                    String user = scan.nextLine();
                    int CategoryLength = 0;
                    String[] categoryName = new String[8000];
                    Integer[] reservationCount = new Integer[8000];
                    Arrays.fill(reservationCount, 0);
                    for (int j = 0; j < 8000; j++) {
                        if (user.equals(name[j])) {
                            if (Arrays.asList(categoryName).contains(category[j])) {
                                int indexOfCategory = Arrays.asList(categoryName).indexOf(category[j]);
                                reservationCount[indexOfCategory]++;
                            } else {
                                categoryName[CategoryLength] = category[j];
                                reservationCount[CategoryLength]++;
                                CategoryLength++;
                            }
                        }

                    }
                    for (int j = 0; j < 8000; j++) {
                        if (reservationCount[j] > 0) {
                            System.out.println(categoryName[j] + " = " + reservationCount[j]);

                        }
                    }
                    System.out.println();
                    System.out.println("kullanici adi girmek istiyor musunuz? evet-hayir");
                    control = scan.nextLine();

                }
                break;
            case 2:
                control = "evet";
                while (control.equals("evet")) {
                    System.out.println("kategori adi giriniz: ");
                    String cat = scan.nextLine();
                    int CategoryLength = 0;
                    String[] username = new String[8000];
                    Integer[] kullanicisay = new Integer[8000];
                    Arrays.fill(kullanicisay, 0);
                    for (int j = 0; j < 8000; j++) {
                        if (cat.equals(category[j])) {
                            if (Arrays.asList(username).contains(name[j])) {
                                int indexOfCategory = Arrays.asList(username).indexOf(name[j]);
                                kullanicisay[indexOfCategory]++;
                            } else {
                                username[CategoryLength] = name[j];
                                kullanicisay[CategoryLength]++;
                                CategoryLength++;
                            }
                        }

                    }
                    for (int j = 0; j < 8000; j++) {
                        if (kullanicisay[j] > 0) {
                            System.out.println(username[j] + " = " + kullanicisay[j]);

                        }
                    }
                    System.out.println();
                    
                    int sayaccccc=0;
                    for (int xx=0;xx<kullanicisay.length;xx++){
                        if (kullanicisay[xx]!=0) sayaccccc++;
                    }

                    if (sayaccccc !=0){
                        for (int xx=0;xx<sayaccccc;xx++){
                            System.out.print(kullanicisay[xx]+" ");
                        }
                        System.out.println();
                    }else {
                        System.out.println("Hiç bu kategoride rezervasyon yok");
                    }


                    System.out.println("kategori adi girmek istiyor musunuz? evet-hayir");
                    control = scan.nextLine();
                }

                break;
            case 3:
                control = "evet";
                while (control.equals("evet")) {
                    System.out.println("Rezervasyon yeri giriniz: ");
                    String cat = scan.nextLine();
                    int CategoryLength = 0;
                    String[] username = new String[8000];
                    Integer[] kullanicisay = new Integer[8000];
                    Arrays.fill(kullanicisay, 0);
                    for (int j = 0; j < 8000; j++) {
                        if (cat.equals(placeid[j])) {
                            if (Arrays.asList(username).contains(name[j])) {
                                int indexOfCategory = Arrays.asList(username).indexOf(name[j]);
                                kullanicisay[indexOfCategory]++;
                            } else {
                                username[CategoryLength] = name[j];
                                kullanicisay[CategoryLength]++;
                                CategoryLength++;
                            }
                        }

                    }
                    for (int j = 0; j < 8000; j++) {
                        if (kullanicisay[j] > 0) {
                            System.out.println(username[j] + " = " + kullanicisay[j]);

                        }
                    }
                    System.out.println();
                    System.out.println("kullanici adi girmek istiyor musunuz? evet-hayir");
                    control = scan.nextLine();
                }
                break;
            case 4:
                control = "evet";
                while (control.equals("evet")) {
                    System.out.println("Kullanici adi giriniz: ");
                    String cat = scan.nextLine();
                    int CategoryLength = 0;
                    String[] username = new String[8000];
                    String[] place = new String[8000];
                    String[] en = new String[8000];
                    String[] boy = new String[8000];
                    String[] sehir = new String[8000];

                    Integer[] kullanicisay = new Integer[8000];
                    Arrays.fill(kullanicisay, 0);
                    for (int j = 0; j < 8000; j++) {
                        if (cat.equals(name[j])) {
                            if (Arrays.asList(username).contains(category[j])) {
                                int indexOfCategory = Arrays.asList(username).indexOf(category[j]);
                                kullanicisay[indexOfCategory]++;
                            } else {
                                username[CategoryLength] = category[j];
                                kullanicisay[CategoryLength]++;
                                place[CategoryLength] = placeid[j];
                                en[CategoryLength] = enlem[j];
                                boy[CategoryLength] = boylam[j];
                                sehir[CategoryLength] = city[j];

                                CategoryLength++;
                            }
                        }

                    }
                    for (int j = 0; j < 8000; j++) {
                        if (kullanicisay[j] > 0) {
                            System.out.println(username[j] + " = " + kullanicisay[j] + "  " + place[j] + "  " + en[j] + "  " + boy[j] + "  " + sehir[j]);

                        }
                    }
                    System.out.println("kullanici adi girmek istiyor musunuz? evet-hayir");
                    control = scan.nextLine();
                }
                break;

            case 5:

                int rezervasyons = 0;
                System.out.println("Kategori bilgileri icin girmek istediginiz kategoriyi yaziniz");
                String cat = scan.nextLine();
                cat = scan.nextLine();
                int subCategoryCount = 0;
                ArrayList<String> alreadyWritten = new ArrayList<String>();
                for (int j = 0; j < 8000; j++) {
                    if (deneme2[j][6] == null) {
                        continue;
                    }
                    String[] categoryNames = deneme2[j][6].split(":");
                    for (int k = 0; k < categoryNames.length; k++) {
                        if (categoryNames[k].equals(cat) && k != categoryNames.length - 1 && !alreadyWritten.contains(categoryNames[categoryNames.length - 1])) {
                            alreadyWritten.add(categoryNames[categoryNames.length - 1]);
                            subCategoryCount++;
                        }
                        if (categoryNames[k].equals(cat)) {
                            rezervasyons++;
                        }
                    }

                }
                System.out.println("Kategori ismi: " + cat);
                System.out.println("Alt kategori sayısı: " + subCategoryCount);
                System.out.println("Rezervasyon Sayisi:" + rezervasyons);
                break;
        }


        br.close();



    }
}