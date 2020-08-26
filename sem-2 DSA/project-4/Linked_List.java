import java.util.Scanner;

public class Linked_List {

	static Scanner sc = new Scanner(System.in);
	static Node start = null, end = null;

	public static void create() {
		Node p, q;

		p = new Node();
		System.out.println("enter reg no");
		p.regd_no = sc.nextInt();
		System.out.println("enter marks");
		p.mark = sc.nextFloat();
		start = p;
		end = p;
		System.out.println("do you want to insert");
		System.out.println("yes=1");
		System.out.println("no=0");
		int O = sc.nextInt();
		while (O != 0 && O == 1) {
			q = new Node();
			System.out.println("enter reg no");
			q.regd_no = sc.nextInt();
			System.out.println("enter marks");
			q.mark = sc.nextFloat();
			p.next = q;
			q.prev = p;
			end = q;
			p = q;

			System.out.println("do you want to insert");
			System.out.println("yes=1");
			System.out.println("no=0");
			O = sc.nextInt();

		}
	}

	public static void display() {
		Node p;

		if (start == null) {
			System.out.println("linklist is empty");
		} else {
			p = start;
			while (p != null) {
				System.out.print("reg no = ");
				System.out.print(p.regd_no);
				System.out.print("  got " + p.mark + " marks");
				System.out.println();

				p = p.next;
			}
		}

	}

	public static Node InsBeg() {

		Node p;
		p = new Node();
		System.out.println("enter reg no");
		p.regd_no = sc.nextInt();
		System.out.println("enter marks");
		p.mark = sc.nextFloat();
		p.next = start;
		start.prev = p;
		start = p;
		return (start);

	}

	public static Node InsEnd() {

		Node q;

		q = new Node();
		System.out.println("enter reg no");
		q.regd_no = sc.nextInt();
		System.out.println("enter marks");
		q.mark = sc.nextFloat();
		q.prev = null;
		q.next = null;
		end.next = q;
		q.prev = end;
		end = q;
		return end;
	}

	public static Node InsAny() {

		Node p, q;
		System.out.println("enter positiion to add");
		int pos = sc.nextInt();
		p = start;
		for (int i = 1; i <= pos; i++) {
			if (i == pos) {
				q = new Node();
				System.out.println("enter reg no");
				q.regd_no = sc.nextInt();
				System.out.println("enter marks");
				q.mark = sc.nextFloat();
				q.next = p.next.prev;
				q.prev = p.prev;
				p.prev.next = q;
				p.prev = q;

				break;

			}

			p = p.next;

		}
		return start;
	}

	public static Node DelBeg() {
		start = start.next;
		start.prev = null;
		return start;
	}

	public static Node DelEnd() {
		end = end.prev;
		end.next = null;
		return end;
	}

	public static Node DelAny() {

		Node p;
		System.out.println("enter positiion to add");
		int pos = sc.nextInt();
		p = start;
		for (int i = 1; i <= pos; i++) {
			if (i == pos) {
				p.next.prev = p.prev;
				p.prev.next = p.next;
			}

			p = p.next;
		}
		return start;
	}

	public static void search() {

		Node p;
		p = start;
		int flag = 0, i = 1;
		System.out.println("Enter the reg. no to search");
		int key = sc.nextInt();
		while (p != null) {
			if (key == p.regd_no) {
				flag = 1;

				break;
			}
			i++;
			p = p.next;
		}
		if (flag != 0)
			System.out.println("Found" + " at position " + i);
		else
			System.out.println("Not found");

	}

	public static void sort() {
		Node p, q;
		for (p = start; p != null; p = p.next) {
			for (q = start; q != null; q = q.next) {
				if (q.regd_no > p.regd_no) {
					int temp = q.regd_no;
					q.regd_no = p.regd_no;
					p.regd_no = temp;
					float temp2 = q.mark;
					q.mark = p.mark;
					p.mark = temp2;

				}
			}
		}
	}

	public static int count() {

		int c = 0;
		Node p;
		p = start;

		while (p != null) {
			c = c + 1;
			p = p.next;
		}

		return (c);
	}

	public static Node reverse() {
		Node p, q = null, r = null;
		p = start;
		while (p != null) {
			q = p.next;
			p.next = r;
			r = p;
			p = q;
		}
		start = r;
		return start;
	}

	public static void main(String[] args) {

		while (true) {
			System.out.println("\n****MENU****");
			System.out.println("\n0: Exit");
			System.out.println("1: Creation");
			System.out.println("2: Display");
			System.out.println("3: Insert at begning");
			System.out.println("4: Insert at end");
			System.out.println("5: Insert at any point");
			System.out.println("6: Delete at begnning point");
			System.out.println("7: Delete at end");
			System.out.println("8: Delete at any point");
			System.out.println("9: Search");
			System.out.println("10:Sort");
			System.out.println("11:Count");
			System.out.println("12:Reverse");

			System.out.println("\nEnter the choice");
			int choice = sc.nextInt();
			switch (choice) {
			case 0:
				System.exit(0);
			case 1:
				create();
				break;
			case 2:
				display();
				break;
			case 3:
				start = InsBeg();
				break;
			case 4:
				end = InsEnd();
				break;
			case 5:
				start = InsAny();
				break;
			case 6:
				start = DelBeg();
				break;
			case 7:
				end = DelEnd();
				break;
			case 8:
				start = DelAny();
				break;
			case 9:
				search();
				break;
			case 10:
				sort();
				break;
			case 11:
				int x = count();
				System.out.println("no of nodes = " + x);
				break;
			case 12:
				start = reverse();
				break;
			default:
				System.out.println("Wrong choice");
			}
		}

	}

}
