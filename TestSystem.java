import java.util.Scanner;

public class TestSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilih;
        char ulang = 'y';
        int loginAttempts = 3;
        boolean isLoggedIn = false; // Tambahkan variabel untuk menyimpan status login

        System.out.println("=====================================================================");
        System.out.println("  __  __   _           _   __  __                  _             _   \r\n" + //
                " |  \\/  | (_)         (_) |  \\/  |                | |           | |  \r\n" + //
                " | \\  / |  _   _ __    _  | \\  / |   __ _   _ __  | | __   ___  | |_ \r\n" + //
                " | |\\/| | | | | '_ \\  | | | |\\/| |  / _` | | '__| | |/ /  / _ \\ | __|\r\n" + //
                " | |  | | | | | | | | | | | |  | | | (_| | | |    |   <  |  __/ | |_ \r\n" + //
                " |_|  |_| |_| |_| |_| |_| |_|  |_|  \\__,_| |_|    |_|\\_\\  \\___|  \\__|\r\n" + //
                "                                                                     \r\n" + //
                "                                                                     ");
        System.out.println("=====================================================================");
        System.out.println(" ");

        // Bagian login ditempatkan sebelum loop do-while
        System.out.println("=====================================================================");
        System.out.println(" \t\t\tHALAMAN LOGIN PEGAWAI ");
        System.out.println("=====================================================================");
        String[] username = { "kasir", "admin" };
        int[] password = { 111, 112 };

        while (!isLoggedIn && loginAttempts > 0) { // Jika belum login, tampilkan menu login
            System.out.println("-----------------------------------------------------------------");
            System.out.println("|\t\tMasukkan Username dan Password Anda              |");
            System.out.println("-----------------------------------------------------------------");
            System.out.print("| Username    : ");
            String user = sc.next();
            sc.nextLine();
            System.out.print("| Password    : ");
            int pw = sc.nextInt();
            System.out.println("----------------------------------------------------");

            for (int i = 0; i < password.length; i++) {
                if (user.equals(username[i]) && pw == password[i]) {
                    System.out.println("Selamat Datang " + username[i] + " Anda Berhasil Login");
                    isLoggedIn = true; // Ubah status login menjadi true
                    break;
                }
            }
            if (!isLoggedIn) {
                loginAttempts--; // Kurangi kesempatan login jika login gagal
                System.out.println("Login gagal! Kesempatan login tersisa: " + loginAttempts);
                if (loginAttempts == 0) {
                    System.out.println("Anda telah menggunakan semua kesempatan login.");
                    return; // Keluar dari loop jika kesempatan login telah habis
                }
            }
        }
        do {
            System.out.println(" ");
            System.out.println("-------- Pilih Menu -----------");
            System.out.println("1. Daftar Harga\n2. Transaksi\n3. Retur Barang\n4. Laporan Pendapatan Harian");
            System.out.println("Pilih 0 jika ingin mengakhiri kegiatan");
            System.out.println(" ");
            System.out.print("Masukkan menu : ");
            pilih = sc.nextInt();
            System.out.println(" ");

            switch (pilih) {
                case 0:
                    System.out.println("Terimakasih Atas Kunjungannya !");
                    break;

                case 1:
                    System.out.println("=====================================");
                    System.out.println(" \t DAFTAR HARGA ");
                    System.out.println("=====================================");

                    System.out.print("Banyak barang yang akan diinput : ");
                    int jumlahBarang = sc.nextInt();

                    String[] namaBarang = new String[jumlahBarang];
                    int[] hargaBarang = new int[jumlahBarang];
                    int[] stokBarang = new int[jumlahBarang];

                    for (int i = 0; i < jumlahBarang; i++) {
                        System.out.print("Nama Barang " + (i + 1) + " : ");
                        namaBarang[i] = sc.next();
                        System.out.print("Harga       : ");
                        hargaBarang[i] = sc.nextInt();
                        System.out.print("Banyak Stok : ");
                        stokBarang[i] = sc.nextInt();
                        System.out.println();
                    }

                    // Tampilkan daftar barang dengan format tabel
                    System.out.println("============================================================");
                    System.out.println("|| No. ||   Nama Barang   ||   Harga   ||   Banyak Stok   ||");
                    System.out.println("============================================================");
                    for (int i = 0; i < jumlahBarang; i++) {
                        System.out.printf("|| %-3d || %-15s || %-9d || %-15d ||\n", (i + 1), namaBarang[i],
                                hargaBarang[i], stokBarang[i]);
                    }
                    System.out.println("============================================================");

                    // Mencari barang
                    System.out.println("------------------------------------------");
                    System.out.print("Apakah ingin mencari barang? (y/t) : ");
                    char cariBarang = sc.next().charAt(0);
                    System.out.println();

                    if (cariBarang == 'Y' || cariBarang == 'y') {
                        System.out.print("Masukkan nama barang yang ingin dicari : ");
                        String barangDicari = sc.next();
                        System.out.println();

                        boolean ditemukan = false;
                        for (int i = 0; i < jumlahBarang; i++) {
                            if (namaBarang[i].equalsIgnoreCase(barangDicari)) {
                                System.out.println("========== Barang ditemukan ==========");
                                System.out.println("Nama Barang : " + namaBarang[i]);
                                System.out.println("Harga       : " + hargaBarang[i]);
                                System.out.println("Stok        : " + stokBarang[i]);
                                ditemukan = true;
                                break;
                            }
                        }

                        if (!ditemukan) {
                            System.out.println("Barang tidak ditemukan.");
                        }
                    }
                    break;

                case 2:
                    System.out.println("=====================================");
                    System.out.println(" \t   TRANSAKSI ");
                    System.out.println("=====================================");

                    System.out.print("Masukkan nama pelanggan         : ");
                    String namaPelanggan = sc.next();

                    System.out.print("Apakah pelanggan adalah member (y/t)? ");
                    boolean isMember = sc.next().equalsIgnoreCase("y");

                    double totalHargaSebelumDiskon = 0;
                    double totalDiskon = 0;
                    int totalItemBarang = 0;

                    boolean tambahProduk = true;
                    while (tambahProduk) {
                        System.out.println(" ");
                        System.out.print("Masukkan nama produk          : ");
                        String namaProduk = sc.next();

                        System.out.print("Masukkan kuantitas produk     : ");
                        int kuantitas = sc.nextInt();

                        System.out.print("Masukkan harga satuan produk  : ");
                        double hargaSatuan = sc.nextDouble();

                        System.out.print("Diskon dalam persentase (%)   : ");
                        double diskonProduk = sc.nextDouble();

                        totalItemBarang += kuantitas;
                        double subTotal = kuantitas * hargaSatuan;

                        double diskon = subTotal * (diskonProduk / 100);
                        totalDiskon += diskon;

                        totalHargaSebelumDiskon += subTotal;

                        System.out.println(" ");
                        System.out.print("Tambah produk lagi (y/t)? ");
                        tambahProduk = sc.next().equalsIgnoreCase("y");
                    }

                    double diskonMember = 0;
                    if (isMember) {
                        if (totalHargaSebelumDiskon >= 200000) {
                            diskonMember = totalHargaSebelumDiskon * 0.1;
                        } else {
                            diskonMember = totalHargaSebelumDiskon * 0.05;
                        }
                    }

                    double totalAkhir = totalHargaSebelumDiskon - totalDiskon - diskonMember;

                    System.out.println("Nama Pelanggan                 : " + namaPelanggan);
                    System.out.println("Tipe Pelanggan                 : " + (isMember ? "Member" : "Bukan Member"));
                    System.out.println("Total Item Barang              : " + totalItemBarang);
                    System.out.println("Total Harga Sebelum Diskon     : " + totalHargaSebelumDiskon);
                    System.out.println("Total Diskon                   : " + totalDiskon);
                    System.out.println("Diskon Member                  : " + diskonMember);
                    System.out.println("Total Akhir                    : " + totalAkhir);
                    System.out.println(" ");

                    System.out.println("===== Metode Pembayaran =====");
                    System.out.println("1. Kartu Kredit");
                    System.out.println("2. Tunai");
                    System.out.println("---------------------------- ");
                    System.out.print("Pilih metode pembayaran: ");
                    int metodePembayaran = sc.nextInt();
                    System.out.println(" ");

                    if (metodePembayaran == 1) {
                        System.out.println("Pembayaran dengan Kartu Kredit berhasil.");
                    } else if (metodePembayaran == 2) {
                        System.out.print("Tunai (masukkan jumlah uang): Rp");
                        int uangTunai = sc.nextInt();
                        int kembalian = uangTunai - (int) totalAkhir;
                        if (kembalian >= 0) {
                            System.out.println("Kembalian               : Rp" + kembalian);
                        } else {
                            System.out.println("Uang tunai tidak mencukupi.");
                        }
                    } else {
                        System.out.println("Metode pembayaran tidak valid.");
                    }

                    System.out.println("Terima kasih telah berbelanja!");

                    break;

                case 3:
                    System.out.println("=====================================");
                    System.out.println("\t RETUR BARANG ");
                    System.out.println("=====================================");

                    String nm, kondisi;
                    int jmlStok, jmlBarang;

                    System.out.print("Masukkan nama barang  : ");
                    nm = sc.next();
                    System.out.print("Masukkan banyak stok  : ");
                    jmlStok = sc.nextInt();
                    System.out.print("Apakah kondisi stok baik ? (y/t)");
                    kondisi = sc.next();
                    System.out.print("Masukkan jumlah barang: ");
                    jmlBarang = sc.nextInt();

                    if (jmlStok == jmlBarang) {
                        if (kondisi.equals("y")) {
                            System.out.println("Pasang di etalase");
                        } else {
                            System.out.println("Lakukan retur");
                        }
                    } else {
                        System.out.println("Laporkan");
                    }
                    break;

                case 4:
                    System.out.println("=====================================");
                    System.out.println(" \tLAPORAN HARIAN ");
                    System.out.println("=====================================");

                    int jumlahHari = 30;
                    double totalBulanan = 0;

                    for (int hari = 1; hari <= jumlahHari; hari++) {
                        System.out.println("Hari " + hari + " - Penjualan:");
                        double totalHarian = 0;
                        for (int item = 1; item <= 3; item++) {
                            System.out.print("Masukkan jumlah " + "item " + item + " yang terjual: ");
                            int jumlahItem = sc.nextInt();

                            double hargaItem = 2000;
                            double totalItem = hargaItem * jumlahItem;
                            System.out.println("Item " + item + " - Total: Rp " + totalItem);
                            totalHarian += totalItem;
                        }
                        System.out.println("Total Penjualan Hari " + hari + ": Rp " + totalHarian);
                        System.out.println("------------------------");

                        totalBulanan += totalHarian;
                    }

                    System.out.println("Total Penjualan Bulan Ini: Rp " + totalBulanan);

                    break;

                default:
                    System.out.println("Menu tidak di temukan");
                    break;

            }

            System.out.println("Ingin lanjut? (y/t)");
            ulang = sc.next().charAt(0);

        } while (ulang != 't');

        System.out.println("Terimakasih Atas Kunjungannya !");
    }
}