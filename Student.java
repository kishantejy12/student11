import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Student {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public void addRecords() throws IOException {
		// Create or Modify a file for Database
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("studentRecords.txt", true)));
		String name, Class, address, dob;
		int age;
		long telephoneNo;
		String s;
		boolean addMore = false;
		// Read Data
		do {
			System.out.println(" THERE ARE TWO CLASSES 1.CLASS A AND 2.CLASS B");
			System.out.println("ENTRE YOUR NUMBER");
			Scanner s1 = new Scanner(System.in);
			int q = s1.nextInt();

			if (q == 1) {
				System.out.println("ENTRE YOUR NUMBER");
				int z = s1.nextInt();
				if (z == 1) {
					System.out.print("\nEnter name: ");
					name = br.readLine();

					System.out.print("Address: ");
					address = br.readLine();

					System.out.print("Class: ");
					Class = br.readLine();

					System.out.print("Date of Birth (dd/mm/yy) : ");
					dob = br.readLine();

					System.out.print("Age: ");
					age = Integer.parseInt(br.readLine());

					System.out.print("Telephone No.: ");
					telephoneNo = Long.parseLong(br.readLine());
					// Print to File
					pw.println(name);
					pw.println(address);
					pw.println(Class);
					pw.println(dob);
					pw.println(age);
					pw.println(telephoneNo);
					System.out.print("\nRecords added successfully !\n\nDo you want to add more records ? (y/n) : ");
					s = br.readLine();
					if (s.equalsIgnoreCase("y")) {
						addMore = true;
						System.out.println();
					} else
						addMore = false;
				} else {

					// System.out.println(" ");

					// System.out.println("ENTRE YOUR NUMBER");
					// Scanner s2= new Scanner(System.in);
					// int q1=s2.nextInt();

				}
			} else {

			}
			{
				System.out.print("\nEnter name: ");
				name = br.readLine();

				System.out.print("Address: ");
				address = br.readLine();

				System.out.print("Class: ");
				Class = br.readLine();

				System.out.print("Date of Birth (dd/mm/yy) : ");
				dob = br.readLine();

				System.out.print("Age: ");
				age = Integer.parseInt(br.readLine());

				System.out.print("Telephone No.: ");
				telephoneNo = Long.parseLong(br.readLine());
				// Print to File
				pw.println(name);
				pw.println(address);
				pw.println(Class);
				pw.println(dob);
				pw.println(age);
				pw.println(telephoneNo);
			}
			System.out.print("\nRecords added successfully !\n\nDo you want to add more records ? (y/n) : ");
			s = br.readLine();
			if (s.equalsIgnoreCase("y")) {
				addMore = true;
				System.out.println();
			} else
				addMore = false;
		}
		/*
		 * while(addMore); pw.close(); showMenu();
		 */

		while (addMore);
		pw.close();
		ddd();

	}

	public void readRecords() throws IOException {
		try {
			// Open the file
			BufferedReader file = new BufferedReader(new FileReader("studentRecords.txt"));
			String name;
			int i = 1;
			// Read records from the file
			while ((name = file.readLine()) != null) {
				System.out.println("S.No. : " + (i++));
				System.out.println("-------------");
				System.out.println("\nName: " + name);
				System.out.println("Address: " + file.readLine());
				System.out.println("Class: " + file.readLine());
				System.out.println("Date of Birth : " + file.readLine());
				System.out.println("Age: " + Integer.parseInt(file.readLine()));
				System.out.println("Tel. No.: " + Long.parseLong(file.readLine()));
				System.out.println();

			}

			file.close();
			ddd();
		} catch (FileNotFoundException e) {
			System.out.println("\nERROR : File not Found !!!");
		}
	}

	public void search() throws IOException {
		// Create a blank file
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("studentRecords.txt")));
		pw.close();
		System.out.println("\nAll Records cleared successfully !");
		for (int i = 0; i < 999999999; i++)
			; // Wait for some time
		ddd();
	}

	public void ddd() throws IOException {
		System.out.print("1 : Add Student\n2 : Display Students\n3 : Clear All Data\n4 : Exit\n\nENTER YOUR NUMBER : ");
		int choice = Integer.parseInt(br.readLine());
		switch (choice) {

		case 1:
			addRecords();
			break;
		case 2:
			System.out.println("Enter  1 for display  or 2 for search ");
			Scanner s1 = new Scanner(System.in);
			int q = s1.nextInt();
			if (q == 1)
				readRecords();
			else {

				File file1 = new File("studentRecords.txt");

				Scanner kb = new Scanner(System.in);

				System.out.println(" enter the content you looking for");
				String name1 = kb.next();
				Scanner scanner;
				try {
					scanner = new Scanner(file1).useDelimiter(",");

					while (scanner.hasNext()) {
						final String lineFromFile = scanner.nextLine();
						if (lineFromFile.contains(name1)) {
							// a match!
							System.out.println("I found " + name1);
							break;
						}
					}
				} catch (IOException e) {
					System.out.println(" cannot write to file " + file1.toString());
				}
			}

			break;
		case 3:
			search();
			// clear();
			break;
		case 4:
			System.exit(1);
			break;

		default:
			System.out.println("\nInvalid Choice !");
			break;
		}

	}

	public static void main(String args[]) throws IOException {
		System.out.println(" TWO CLASSES 1.CLASS A 2. CLASS B");
		Student call = new Student();
		call.ddd();

	}

}
