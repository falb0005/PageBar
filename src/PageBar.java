import java.util.Scanner;

public class PageBar {

	public static final int NUM_PAGES = 21;
	public static final int PAGES_TO_SHOW = 9; // Should be an Odd number
	
	public static void main(String[] args) {
		System.out.println("*****Page Bar*****");
		Scanner input = new Scanner(System.in);
		int currentPage = 1;
		boolean isRunning = true;
		while(isRunning){
			String inputString = input.nextLine();
			switch(inputString){
				case "<":
					if(currentPage > 1) {
						currentPage--;
					}
					break;
				case ">":
					if(currentPage < NUM_PAGES){
						currentPage++;
					}
					break;
				case "exit":
					isRunning = false;
					break;
			}
			if(isRunning){
				PageBar.printPages(PageBar.generatePages(currentPage));
			}
		}
		input.close();
	}
	
	public static String[] generatePages(int currentPage){
		String[] pageLinks = new String[PAGES_TO_SHOW + 2];
		pageLinks[0] = "< ";
		
		// calculate the starting page
		int startingPage = currentPage;
		if(startingPage > NUM_PAGES - (PAGES_TO_SHOW / 2)){
			startingPage = startingPage - (PAGES_TO_SHOW - 1) - (startingPage - NUM_PAGES) ;
		}else{
			startingPage -= PAGES_TO_SHOW / 2;
		}
		if(startingPage < 1) {
			startingPage = 1;
		}
		int startingPageDifference = startingPage - currentPage;
		
		// calculate the finishing page based on the starting page difference
		int finishingPage = currentPage + (PAGES_TO_SHOW - 1) + startingPageDifference;
		if(finishingPage > NUM_PAGES){
			finishingPage = NUM_PAGES;
		}
		
		int pageIndex = 1;
		for(int i = startingPage; i <= finishingPage; i++){
			if(i == currentPage){
				pageLinks[pageIndex] = "- ";
			}else{
				pageLinks[pageIndex] = Integer.toString(i) + " ";
			}
			pageIndex++;
		}
		
		pageLinks[PAGES_TO_SHOW + 1] = "> ";
		
		return pageLinks;
	}
	
	public static void printPages(String [] pageLinks){
		for(String page : pageLinks){
			System.out.print(page);
		}
		System.out.println("");
	}
}
