
import java.util.*;
import java.text.DecimalFormat;

class FinalCourseWork {

 public static Scanner input = new Scanner(System.in);
   public static DecimalFormat df = new DecimalFormat("#.00");

   public static int OrderID_get = 1;
   public static String OrderID = "";
   public static String tshirt_size = "";
   public static int tshirt_size_to_price = 0;
   public static int qty = 0;
   public static String customer_phone_number;
   public static String orderID_read;
   public static double amount;

   public static final String[] order_status = { "PROCESSING", "DELEVERING", "DELIVERED" };

   public static String[] OrderID_Array = new String[0];
   public static String[] customer_phone_number_Array = new String[0];
   public static String[] tshirt_size_Array = new String[0];
   public static int[] qty_Array = new int[0];
   public static String[] order_stats_Array = new String[0];
   public static double[] amount_Array = new double[0];

   public static void PlaceOrder() {
      clearConsole();
      String title_place_order = "  _____  _          " +
            "         ____       " +
            "   _           \r\n" +
            " |  __ \\| |        " +
            "         / __ \\    " +
            "    | |          \r" +
            "\n" +
            " | |__) | | __ _  __" +
            "_ ___  | |  | |_ __ " +
            "__| | ___ _ __ \r\n" +
            " |  ___/| |/ _` |/ _" +
            "_/ _ \\ | |  | | \'_" +
            "_/ _` |/ _ \\ \'__|" +
            "\r\n" +
            " | |    | | (_| | (_" +
            "|  __/ | |__| | | | " +
            "(_| |  __/ |   \r\n" +
            " |_|    |_|\\__,_|\\" +
            "___\\___|  \\____/|_" +
            "|  \\__,_|\\___|_|";

      boolean c_number_check = true;

      System.out.println(title_place_order);
      System.out.println("_________________________________________________________\n\n");

      System.out.println("Enter OrderID : " + ("ODR#" + String.format("%05d", OrderID_get)));
      OrderID = "ODR#" + String.format("%05d", OrderID_get);

      do {
         System.out.print("\nEnter Customer Phone Number : ");
         customer_phone_number = input.next();

         if (customer_phone_number.length() == 10 && customer_phone_number.charAt(0) == '0') {
            c_number_check = false;
         } else {
            System.out.println("\t\tInvalid Phone number... Try again");
            System.out.println("\nDo you want to Enter Phone Number again? (y/n)");
            char c_number_reinput = input.next().charAt(0);

            if (c_number_reinput == 'Y' || c_number_reinput == 'y') {
               System.out.print("\033[F\033[K");
               System.out.print("\033[F\033[K");
               System.out.print("\033[F\033[K");
               System.out.print("\033[F\033[K");
               System.out.print("\033[F\033[K");
               System.out.print("\033[F\033[K");
               c_number_check = true;
            } else {
               home();
            }
         }

      } while (c_number_check);

      boolean tshirt_size_iscorrect = true;
      do {
         System.out.print("\nEnter Tshirt Size (XS/S/M/L/XL/XXL) : ");
         tshirt_size = input.next().toUpperCase();

         if (tshirt_size.equals("XS") || tshirt_size.equals("S") || tshirt_size.equals("M") || tshirt_size.equals("L")
               || tshirt_size.equals("XL") || tshirt_size.equals("XXL")) {
            tshirt_size_iscorrect = false;
         } else {
            tshirt_size_iscorrect = true;
            System.out.print("\033[F\033[K");
            System.out.print("\033[F\033[K");
         }

      } while (tshirt_size_iscorrect);

      switch (tshirt_size) {
         case "XS":
            tshirt_size_to_price = 600;
            break;

         case "S":
            tshirt_size_to_price = 800;
            break;

         case "M":
            tshirt_size_to_price = 900;
            break;

         case "L":
            tshirt_size_to_price = 1000;
            break;

         case "XL":
            tshirt_size_to_price = 1100;
            break;

         case "XXL":
            tshirt_size_to_price = 1200;
            break;

      }

      boolean qty_isCorrect = true;

      do {

         System.out.print("\nEnter QTY : ");
         qty = input.nextInt();

         if (qty > 0) {
            qty_isCorrect = false;
         } else {
            qty_isCorrect = true;
            System.out.print("\033[F\033[K");
            System.out.print("\033[F\033[K");
         }

      } while (qty_isCorrect);

      System.out.println("\nAmount : " + df.format(tshirt_size_to_price * qty));
      double amount_calc = tshirt_size_to_price * qty;


      System.out.println("\nDo you want to place this order? (y/n) : ");
      char option = input.next().charAt(0);

      if (option == 'y' || option == 'Y') {

         String[] temp_OrderID_Array = new String[OrderID_Array.length + 1];
         String[] temp_customer_phone_number_Array = new String[customer_phone_number_Array.length + 1];
         String[] temp_tshirt_size_Array = new String[tshirt_size_Array.length + 1];
         int[] temp_qty_Array = new int[qty_Array.length + 1];
         String[] temp_order_stats_Array = new String[order_stats_Array.length + 1];
         double[] temp_amount_Array = new double[amount_Array.length + 1];

         for (int i = 0; i < OrderID_Array.length; i++) {
            temp_OrderID_Array[i] = OrderID_Array[i];
            temp_customer_phone_number_Array[i] = customer_phone_number_Array[i];
            temp_tshirt_size_Array[i] = tshirt_size_Array[i];
            temp_qty_Array[i] = qty_Array[i];
            temp_order_stats_Array[i] = order_stats_Array[i];
            temp_amount_Array[i] = amount_Array[i];
         }

         OrderID_Array = temp_OrderID_Array;
         OrderID_Array[OrderID_Array.length - 1] = OrderID;

         customer_phone_number_Array = temp_customer_phone_number_Array;
         customer_phone_number_Array[customer_phone_number_Array.length - 1] = customer_phone_number;

         tshirt_size_Array = temp_tshirt_size_Array;
         tshirt_size_Array[tshirt_size_Array.length - 1] = tshirt_size;

         qty_Array = temp_qty_Array;
         qty_Array[qty_Array.length - 1] = qty;

         amount_Array = temp_amount_Array;
         amount_Array[amount_Array.length - 1] = amount_calc;

         order_stats_Array = temp_order_stats_Array;
         order_stats_Array[order_stats_Array.length - 1] = order_status[0];

         System.out.println("\t\tOrder Placed..!");

         System.out.println(Arrays.toString(OrderID_Array));
         System.out.println(Arrays.toString(customer_phone_number_Array));
         System.out.println(Arrays.toString(tshirt_size_Array));
         System.out.println(Arrays.toString(qty_Array));
         System.out.println(Arrays.toString(order_stats_Array));

      } else if (option == 'n' || option == 'N') {
         PlaceOrder();
      } else {
         home();
      }

      System.out.println("\nDo you want to place another order? (y/n) : ");
      char option2 = input.next().charAt(0);

      if (option2 == 'y' || option2 == 'Y') {
         OrderID_get++;
         PlaceOrder();
      } else if (option2 == 'n' || option2 == 'N') {
         home();
      } else {
         home();
      }

   }




   public static void SearchCustomer() {
      clearConsole();
      String title_main = "   _____            " +
            "         _          " +
            "            _       " +
            "                    " +
            " \r\n" +
            "  / ____|           " +
            "        | |         " +
            "           | |      " +
            "                    " +
            " \r\n" +
            " | (___   ___  __ _ " +
            "_ __ ___| |__     __" +
            "_ _   _ ___| |_ ___ " +
            " _ __ ___   ___ _ __" +
            " \r\n" +
            "  \\___ \\ / _ \\/ _" +
            "` | \'__/ __| \'_ \\" +
            "   / __| | | / __| _" +
            "_/ _ \\| \'_ ` _ \\ " +
            "/ _ \\ \'__|\r\n" +
            "  ____) |  __/ (_| |" +
            " | | (__| | | | | (_" +
            "_| |_| \\__ \\ || (_" +
            ") | | | | | |  __/ |" +
            "   \r\n" +
            " |_____/ \\___|\\__," +
            "_|_|  \\___|_| |_|  " +
            "\\___|\\__,_|___/\\_" +
            "_\\___/|_| |_| |_|\\" +
            "___|_|   \r\n";

      System.out.println(title_main);
      System.out.println("__________________________________________________________________________________\n\n");

      int m_total_qty = 0;
      int xl_total_qty = 0;
      int xxl_total_qty = 0;
      int xs_total_qty = 0;
      int s_total_qty = 0;
      int l_total_qty = 0;

      int search_count = 0;

      double m_total_amount = 0;
      double xl_total_amount = 0;
      double xxl_total_amount = 0;
      double xs_total_amount = 0;
      double s_total_amount = 0;
      double l_total_amount = 0;

      System.out.print("Enter Customer Phone Number : ");
      customer_phone_number = input.next();
      System.out.println("");

      for (int i = 0; i < customer_phone_number_Array.length; i++) {
         if (customer_phone_number_Array[i].equals(customer_phone_number)) {
            search_count++;
         }
      }

      if (search_count == 0) {
         System.out.println("\t\tInvalid input..\n\n");
         System.out.print("\nDo you want to search another customer report (y/n) : ");
         char option = input.next().charAt(0);

         if (option == 'y' || option == 'Y') {
            SearchCustomer();
         } else if (option == 'n' || option == 'N') {
            home();
         } else {
            home();
         }
      }

      for (int i = 0; i < customer_phone_number_Array.length; i++) {
         if (customer_phone_number_Array[i].equals(customer_phone_number)) {
            switch (tshirt_size_Array[i]) {
               case "XS":
                  xs_total_qty += qty_Array[i];
                  tshirt_size_to_price = 600;
                  m_total_amount += tshirt_size_to_price * qty_Array[i];
                  break;

               case "S":
                  s_total_qty += qty_Array[i];
                  tshirt_size_to_price = 800;
                  s_total_amount += tshirt_size_to_price * qty_Array[i];
                  break;

               case "M":
                  m_total_qty += qty_Array[i];
                  tshirt_size_to_price = 900;
                  m_total_amount += tshirt_size_to_price * qty_Array[i];
                  break;

               case "L":
                  l_total_qty += qty_Array[i];
                  tshirt_size_to_price = 1000;
                  l_total_amount += tshirt_size_to_price * qty_Array[i];
                  break;

               case "XL":
                  xl_total_qty += qty_Array[i];
                  tshirt_size_to_price = 1100;
                  xl_total_amount += tshirt_size_to_price * qty_Array[i];
                  break;

               case "XXL":
                  xxl_total_qty += qty_Array[i];
                  tshirt_size_to_price = 1200;
                  xxl_total_amount += tshirt_size_to_price * qty_Array[i];
                  break;

            }

         }

      }

      System.out.println("+---------------+--------------------+-------------------+");
      System.out.printf("|%-15s|%-17s|%-17s|", "      Size   ", "      Quantity      ", "      Amount       ");
      System.out.println();
      System.out.println("+---------------+--------------------+-------------------+");
      System.out.printf("|%-15s|%-20s|%-19s|", "", "", "");
      System.out.println();
      System.out.printf("|%-15s|%-20s|%19s|", " M", " " + m_total_qty, m_total_amount + " ");
      System.out.println();
      System.out.printf("|%-15s|%-20s|%-19s|", "", "", "");
      System.out.println();
      System.out.printf("|%-15s|%-20s|%19s|", " XL", " " + xl_total_qty, xl_total_amount + " ");
      System.out.println();
      System.out.printf("|%-15s|%-20s|%-19s|", "", "", "");
      System.out.println();
      System.out.printf("|%-15s|%-20s|%19s|", " XXL", " " + xxl_total_qty + "", xxl_total_amount + " ");
      System.out.println();
      System.out.printf("|%-15s|%-20s|%-19s|", "", "", "");
      System.out.println();
      System.out.printf("|%-15s|%-20s|%19s|", " XS", " " + xs_total_qty, xs_total_amount + " ");
      System.out.println();
      System.out.printf("|%-15s|%-20s|%-19s|", "", "", "");
      System.out.println();
      System.out.printf("|%-15s|%-20s|%19s|", " S", " " + s_total_qty, s_total_amount + " ");
      System.out.println();
      System.out.printf("|%-15s|%-20s|%-19s|", "", "", "");
      System.out.println();
      System.out.printf("|%-15s|%-20s|%19s|", " L", " " + l_total_qty, l_total_amount + " ");
      System.out.println();
      System.out.printf("|%-15s|%-20s|%-19s|", "", "", "");
      System.out.println();

      double total_amount = m_total_amount + xl_total_amount + xxl_total_amount + xs_total_amount + s_total_amount
            + l_total_amount;
      System.out.println("+---------------+--------------------+-------------------+");
      System.out.printf("|%-36s|%19s|", "  Total Amount", total_amount + " ");
      System.out.println();
      System.out.println("+---------------+--------------------+-------------------+");

      System.out.print("\nDo you want to search another customer report (y/n) : ");
      char option2 = input.next().charAt(0);

      if (option2 == 'y' || option2 == 'Y') {
         SearchCustomer();
      } else if (option2 == 'n' || option2 == 'N') {
         home();
      } else {
         home();
      }

   }

   public static void SearchOrder() {
      clearConsole();
      String title_main = "   _____            " +
            "         _        __" +
            "__          _       " +
            "    \r\n" +
            "  / ____|           " +
            "        | |      / _" +
            "_ \\        | |     " +
            "     \r\n" +
            " | (___   ___  __ _ " +
            "_ __ ___| |__   | | " +
            " | |_ __ __| | ___ _" +
            " __ \r\n" +
            "  \\___ \\ / _ \\/ _" +
            "` | \'__/ __| \'_ \\" +
            "  | |  | | \'__/ _` " +
            "|/ _ \\ \'__|\r\n" +
            "  ____) |  __/ (_| |" +
            " | | (__| | | | | |_" +
            "_| | | | (_| |  __/ " +
            "|   \r\n" +
            " |_____/ \\___|\\__," +
            "_|_|  \\___|_| |_|  " +
            "\\____/|_|  \\__,_|" +
            "\\___|_|";

      String phone_no = "";
      String size = "";
      int qty = 0;
      double amount = 0;
      String status = "";
      int search_count = 0;

      System.out.println(title_main);
      System.out.println("_________________________________________________________________\n\n");

      System.out.print("Enter order ID : ");
      orderID_read = input.next();

      for (int i = 0; i < OrderID_Array.length; i++) {
         if (OrderID_Array[i].equals(orderID_read)) {
            search_count++;
         }
      }

      if (search_count == 0) {
         System.out.println("\t\tInvalid ID..\n\n");
         System.out.print("Do you want to search another order (y/n) : ");
         char option = input.next().charAt(0);

         if (option == 'y' || option == 'Y') {
            SearchOrder();
         } else if (option == 'n' || option == 'N') {
            home();
         } else {
            home();
         }
      }

      for (int i = 0; i < OrderID_Array.length; i++) {
         if (OrderID_Array[i].equals(orderID_read)) {

            phone_no = customer_phone_number_Array[i];

            size = tshirt_size_Array[i];

            switch (tshirt_size_Array[i]) {
               case "XS":
                  tshirt_size_to_price = 600;
                  break;

               case "S":
                  tshirt_size_to_price = 800;
                  break;

               case "M":
                  tshirt_size_to_price = 900;
                  break;

               case "L":
                  tshirt_size_to_price = 1000;
                  break;

               case "XL":
                  tshirt_size_to_price = 1100;
                  break;

               case "XXL":
                  tshirt_size_to_price = 1200;
                  break;

            }
            qty = qty_Array[i];
            amount = qty_Array[i] * tshirt_size_to_price;
            status = order_stats_Array[i];
         }
      }

      System.out.println("\n");

      System.out.printf("%-15s:%-15s", "Phone Number", " " + phone_no);
      System.out.println();
      System.out.printf("%-15s:%-15s", "Size", " " + size);
      System.out.println();
      System.out.printf("%-15s:%-15s", "QTY", " " + qty);
      System.out.println();
      System.out.printf("%-15s:%-15s", "Amount", " " + amount);
      System.out.println();
      System.out.printf("%-15s:%-15s", "Status", " " + status);
      System.out.println();

      System.out.print("\nDo you want to search another order (y/n) : ");
      char option2 = input.next().charAt(0);

      if (option2 == 'y' || option2 == 'Y') {
         SearchOrder();
      } else if (option2 == 'n' || option2 == 'N') {
         home();
      } else {
         home();
      }

   }


   public static void ViewReports() {
      clearConsole();
            String title_main = "  _____             " +
            "          _       \r" +
            "\n" +
            " |  __ \\           " +
            "          | |      " +
            "\r\n" +
            " | |__) |___ _ __   " +
            "___  _ __| |_ ___ \r" +
            "\n" +
            " |  _  // _ \\ \'_ " +
            "\\ / _ \\| \'__| __/" +
            " __|\r\n" +
            " | | \\ \\  __/ |_) " +
            "| (_) | |  | |_\\__ " +
            "\\\r\n" +
            " |_|  \\_\\___| .__/" +
            " \\___/|_|   \\__|__" +
            "_/\r\n" +
            "            | |     " +
            "                  \r" +
            "\n" +
            "            |_|     " +
            "                  ";

      System.out.println(title_main);
      System.out.println("______________________________________\n\n");
      
   }


   public static void OrderStatus() {
      clearConsole();
      String title_main = "   ____          _  " +
            "            _____ _ " +
            "       _            " +
            " \r\n" +
            "  / __ \\        | |" +
            "            / ____| " +
            "|      | |          " +
            "  \r\n" +
            " | |  | |_ __ __| | " +
            "___ _ __  | (___ | |" +
            "_ __ _| |_ _   _ ___" +
            " \r\n" +
            " | |  | | \'__/ _` |" +
            "/ _ \\ \'__|  \\___ " +
            "\\| __/ _` | __| | |" +
            " / __|\r\n" +
            " | |__| | | | (_| | " +
            " __/ |     ____) | |" +
            "| (_| | |_| |_| \\__" +
            " \\\r\n" +
            "  \\____/|_|  \\__,_" +
            "|\\___|_|    |_____/" +
            " \\__\\__,_|\\__|\\_" +
            "_,_|___/";

      String phone_no = "";
      String size = "";
      int qty = 0;
      double amount = 0;
      String status = "";
      int search_count = 0;
      int status_location = 0;

      System.out.println(title_main);
      System.out.println("_________________________________________________________________\n\n");

      System.out.print("Enter order ID : ");
      orderID_read = input.next();

      for (int i = 0; i < OrderID_Array.length; i++) {
         if (OrderID_Array[i].equals(orderID_read)) {
            search_count++;
            status_location = i;
         }
      }

      if (search_count == 0) {
         System.out.println("\t\tInvalid ID..\n\n");
         System.out.print("Do you want to change status in another order (y/n) : ");
         char option = input.next().charAt(0);

         if (option == 'y' || option == 'Y') {
            OrderStatus();
         } else if (option == 'n' || option == 'N') {
            home();
         } else {
            home();
         }
      }

      for (int i = 0; i < OrderID_Array.length; i++) {
         if (OrderID_Array[i].equals(orderID_read)) {

            phone_no = customer_phone_number_Array[i];

            size = tshirt_size_Array[i];

            switch (tshirt_size_Array[i]) {
               case "XS":
                  tshirt_size_to_price = 600;
                  break;

               case "S":
                  tshirt_size_to_price = 800;
                  break;

               case "M":
                  tshirt_size_to_price = 900;
                  break;

               case "L":
                  tshirt_size_to_price = 1000;
                  break;

               case "XL":
                  tshirt_size_to_price = 1100;
                  break;

               case "XXL":
                  tshirt_size_to_price = 1200;
                  break;

            }
            qty = qty_Array[i];
            amount = qty_Array[i] * tshirt_size_to_price;
            status = order_stats_Array[i];
         }
      }

      System.out.println("\n");

      System.out.printf("%-15s:%-15s", "Phone Number", " " + phone_no);
      System.out.println();
      System.out.printf("%-15s:%-15s", "Size", " " + size);
      System.out.println();
      System.out.printf("%-15s:%-15s", "QTY", " " + qty);
      System.out.println();
      System.out.printf("%-15s:%-15s", "Amount", " " + amount);
      System.out.println();
      System.out.printf("%-15s:%-15s", "Status", " " + status);
      System.out.println();

      System.out.println("\nDo you want to change this order status? (y/n)");
      char change_order_status = input.next().charAt(0);

      if (change_order_status == 'y' || change_order_status == 'Y') {

         switch (status) {

            case "PROCESSING":

               System.out.println("\t[1] Order Delevering");
               System.out.println("\t[2] Order Delevered\n");
               System.out.println("Enter Option : ");
               int option_processing = input.nextInt();

               switch (option_processing) {
                  case 1:
                     order_stats_Array[status_location] = order_status[1];
                     break;

                  case 2:
                     order_stats_Array[status_location] = order_status[2];
                     break;

                  default:
                     OrderStatus();
                     break;

               }

               break;
            case "DELEVERING":
               System.out.println("\t[1] Order Delevered\n");
               System.out.println("Enter Option : ");
               int option_delevering = input.nextInt();

               switch (option_delevering) {
                  case 1:
                     order_stats_Array[status_location] = order_status[2];
                     break;

                  default:
                     OrderStatus();
                     break;
               }

               break;

            case "DELIVERED":

               System.out.println("\tCan't Change this order status, Order already delevered..!");
               break;

            default:
               OrderStatus();
               break;
         }

      } else if (change_order_status == 'n' || change_order_status == 'N') {
         OrderStatus();
      } else {
         home();
      }

      System.out.println("\nDo you want to change another order status (y/n) :");
      char change_another_order_stat = input.next().charAt(0);

      if (change_another_order_stat == 'y' || change_another_order_stat == 'Y') {
         OrderStatus();
      } else if (change_another_order_stat == 'n' || change_another_order_stat == 'N') {
         home();
      } else {
         home();
      }

   }

   public static void DeleteCustomer() {
      clearConsole();

      String title_main = "  _____       _     " +
            " _          ____    " +
            "      _           \r" +
            "\n" +
            " |  __ \\     | |   " +
            " | |        / __ \\ " +
            "       | |          " +
            "\r\n" +
            " | |  | | ___| | ___" +
            "| |_ ___  | |  | |_ " +
            "__ __| | ___ _ __ \r" +
            "\n" +
            " | |  | |/ _ \\ |/ _" +
            " \\ __/ _ \\ | |  | " +
            "| \'__/ _` |/ _ \\ " +
            "\'__|\r\n" +
            " | |__| |  __/ |  __" +
            "/ ||  __/ | |__| | |" +
            " | (_| |  __/ |   \r" +
            "\n" +
            " |_____/ \\___|_|\\_" +
            "__|\\__\\___|  \\___" +
            "_/|_|  \\__,_|\\___|" +
            "_|   ";

      String phone_no = "";
      String size = "";
      int qty = 0;
      double amount = 0;
      String status = "";
      int search_count = 0;
      int delete_id = 0;

      System.out.println(title_main);
      System.out.println("__________________________________________________________\n\n");

      System.out.print("Enter order ID : ");
      orderID_read = input.next();

      for (int i = 0; i < OrderID_Array.length; i++) {
         if (OrderID_Array[i].equals(orderID_read)) {
            delete_id = i;
            search_count++;
         }
      }

      if (search_count == 0) {
         System.out.println("\t\tInvalid ID..\n\n");
         System.out.print("\nDo you want to delete another order (y/n) : ");
         char option = input.next().charAt(0);

         if (option == 'y' || option == 'Y') {
            DeleteCustomer();
         } else if (option == 'n' || option == 'N') {
            home();
         } else {
            home();
         }
      }

      for (int i = 0; i < OrderID_Array.length; i++) {
         if (OrderID_Array[i].equals(orderID_read)) {

            phone_no = customer_phone_number_Array[i];

            size = tshirt_size_Array[i];

            switch (tshirt_size_Array[i]) {
               case "XS":
                  tshirt_size_to_price = 600;
                  break;

               case "S":
                  tshirt_size_to_price = 800;
                  break;

               case "M":
                  tshirt_size_to_price = 900;
                  break;

               case "L":
                  tshirt_size_to_price = 1000;
                  break;

               case "XL":
                  tshirt_size_to_price = 1100;
                  break;

               case "XXL":
                  tshirt_size_to_price = 1200;
                  break;

            }
            qty = qty_Array[i];
            amount = qty_Array[i] * tshirt_size_to_price;
            status = order_stats_Array[i];
         }
      }

      System.out.println("\n");

      System.out.printf("%-15s:%-15s", "Phone Number", " " + phone_no);
      System.out.println();
      System.out.printf("%-15s:%-15s", "Size", " " + size);
      System.out.println();
      System.out.printf("%-15s:%-15s", "QTY", " " + qty);
      System.out.println();
      System.out.printf("%-15s:%-15s", "Amount", " " + amount);
      System.out.println();
      System.out.printf("%-15s:%-15s", "Status", " " + status);
      System.out.println();

      System.out.print("\nDo you want to delete this order (y/n) : ");
      char delete_option = input.next().charAt(0);

      if (delete_option == 'y' || delete_option == 'Y') {

         String[] temp_OrderID_Array = new String[OrderID_Array.length - 1];
         String[] temp_customer_phone_number_Array = new String[customer_phone_number_Array.length - 1];
         String[] temp_tshirt_size_Array = new String[tshirt_size_Array.length - 1];
         int[] temp_qty_Array = new int[qty_Array.length - 1];
         String[] temp_order_stats_Array = new String[order_stats_Array.length - 1];

         for (int i = 0, x = 0; i < OrderID_Array.length - 1; i++) {
            if (i == delete_id) {
               temp_OrderID_Array[delete_id] = OrderID_Array[delete_id + 1];
               temp_customer_phone_number_Array[delete_id] = customer_phone_number_Array[delete_id + 1];
               temp_tshirt_size_Array[delete_id] = tshirt_size_Array[delete_id + 1];
               temp_qty_Array[delete_id] = qty_Array[delete_id + 1];
               temp_order_stats_Array[delete_id] = order_stats_Array[delete_id + 1];

               x++;

            } else {
               temp_OrderID_Array[i] = OrderID_Array[i + x];
               temp_customer_phone_number_Array[i] = customer_phone_number_Array[i + x];
               temp_tshirt_size_Array[i] = tshirt_size_Array[i + x];
               temp_qty_Array[i] = qty_Array[i + x];
               temp_order_stats_Array[i] = order_stats_Array[i + x];
            }
         }

         OrderID_Array = temp_OrderID_Array;
         customer_phone_number_Array = temp_customer_phone_number_Array;
         tshirt_size_Array = temp_tshirt_size_Array;
         qty_Array = temp_qty_Array;
         order_stats_Array = temp_order_stats_Array;

      } else if (delete_option == 'n' || delete_option == 'N') {
         DeleteCustomer();
      }

      System.out.println(Arrays.toString(OrderID_Array));
      System.out.println(Arrays.toString(customer_phone_number_Array));
      System.out.println(Arrays.toString(tshirt_size_Array));
      System.out.println(Arrays.toString(qty_Array));
      System.out.println(Arrays.toString(order_stats_Array));

      System.out.print("\nDo you want to delete another order (y/n) : ");
      char delete_option_2 = input.next().charAt(0);

      if (delete_option_2 == 'y' || delete_option_2 == 'Y') {
         DeleteCustomer();
      } else if (delete_option_2 == 'n' || delete_option_2 == 'N') {
         home();
      } else {
         home();
      }

   }

   public static void home() {
      clearConsole();
      String title_main = "\n\t /$$$$$$$$          " +
            "       /$$       /$$" +
            "                    " +
            "                 /$$" +
            "                    " +
            "      \r\n\t" +
            "| $$_____/          " +
            "      | $$      |__/" +
            "                    " +
            "                | $$" +
            "                    " +
            "      \r\n\t" +
            "| $$    /$$$$$$   /$" +
            "$$$$$$| $$$$$$$  /$$" +
            "  /$$$$$$  /$$$$$$$ " +
            "        /$$$$$$$| $$" +
            "$$$$$   /$$$$$$   /$" +
            "$$$$$ \r\n\t" +
            "| $$$$$|____  $$ /$$" +
            "_____/| $$__  $$| $$" +
            " /$$__  $$| $$__  $$" +
            "       /$$_____/| $$" +
            "__  $$ /$$__  $$ /$$" +
            "__  $$\r\n\t" +
            "| $$__/ /$$$$$$$|  $" +
            "$$$$$ | $$  \\ $$| $" +
            "$| $$  \\ $$| $$  \\" +
            " $$      |  $$$$$$ |" +
            " $$  \\ $$| $$  \\ $" +
            "$| $$  \\ $$\r\n\t" +
            "| $$   /$$__  $$ \\_" +
            "___  $$| $$  | $$| $" +
            "$| $$  | $$| $$  | $" +
            "$       \\____  $$| " +
            "$$  | $$| $$  | $$| " +
            "$$  | $$\r\n\t" +
            "| $$  |  $$$$$$$ /$$" +
            "$$$$$/| $$  | $$| $$" +
            "|  $$$$$$/| $$  | $$" +
            "       /$$$$$$$/| $$" +
            "  | $$|  $$$$$$/| $$" +
            "$$$$$/\r\n\t" +
            "|__/   \\_______/|__" +
            "_____/ |__/  |__/|__" +
            "/ \\______/ |__/  |_" +
            "_/      |_______/ |_" +
            "_/  |__/ \\______/ |" +
            " $$____/ \r\n\t" +
            "                    " +
            "                    " +
            "                    " +
            "                    " +
            "                | $$" +
            "      \r\n\t" +
            "                    " +
            "                    " +
            "                    " +
            "                    " +
            "                | $$" +
            "      \r\n\t" +
            "                    " +
            "                    " +
            "                    " +
            "                    " +
            "                |__/" +
            "      ";

      int input_type;
      do {
         System.out.println(title_main);
         System.out.println(
               "\t________________________________________________________________________________________________________\n\n");
         System.out.println("\t\t [1] Place Order\t\t\t\t[2] Search Customer\n");
         System.out.println("\t\t [3] Search Order\t\t\t\t[4] View Reports\n");
         System.out.println("\t\t [5] Set Order Status\t\t\t\t[6] Delete Order\n");

         System.out.print("\n\n\tInput type : ");
         input_type = input.nextInt();

         switch (input_type) {
            case 1:
               PlaceOrder();
               break;

            case 2:
               SearchCustomer();
               break;

            case 3:
               SearchOrder();
               break;

            case 4:
               ViewReports();
               break;

            case 5:
               OrderStatus();
               break;

            case 6:
               DeleteCustomer();
               break;

         }

         if (input_type < 1 || input_type > 6) {
            clearConsole();
         }

      } while (input_type < 1 || input_type > 6);

   }

   public final static void clearConsole() {
      try {
         final String os = System.getProperty("os.name");
         if (os.contains("Windows")) {
            new ProcessBuilder("cmd", "/c",
                  "cls").inheritIO().start().waitFor();
         } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
         }
      } catch (final Exception e) {
         e.printStackTrace();
         // Handle any exceptions.
      }
   }

   public static void main(String args[]) {
      home();
   }



}

