import java.util.List;


public class driver {

	/**
	 * @param args
	 */
	static void fun(Store store)
	{
		System.out.println("Name of the store : "+ store.getId());
		List<Item> storeItems = store.getItems();
		for( int i =0; i<storeItems.size(); i++)
		{
			System.out.println("\n");
			Item aStoreItem = storeItems.get(i);
			System.out.println("Item no. "+ (i+1) );
			System.out.println("Details of item -> " + " ByWeight : "+ aStoreItem.getByWeight() +
					", Taxable : "+ aStoreItem.getTaxable() +", Default Price : "+ aStoreItem.getDefaultPriceInCents());
			System.out.println("Purchase information -> "  );
			List<Purchase> purchased = aStoreItem.getPurchases();
			
			for( int j =0; j<purchased.size()  ; j++)
			{
				Purchase storePur = purchased.get(j);
				System.out.println("Purchased by " + storePur.getMembershipCard() +
						"No of Quantity " + storePur.getNumberOfItems());
			}
			System.out.println("\n\nSpecial Prices\n");
			List<SpecialPrice> sp = aStoreItem.getSpecialPrices();
			for( int j =0; j<sp.size(); j++)
			{
				SpecialPrice ssp = sp.get(j);
				System.out.println("Special Price : "+ ssp.getPriceInCents());
				List<MembershipCard> mc = ssp.getMembershipCardType().getMembershipCards();
				System.out.println("For "+ mc.size() +" users ");
				for( int k =0; k<mc.size(); k++)
				{
					System.out.println("User " + (k+1));
					System.out.println("Membership card number : " + mc.get(k).getNumber() +" " +
							" Membership card type : "+ mc.get(k).getMembershipCardType().getName());
				}
			}
			
			System.out.println("\n\nGroup Prices\n");
			List<GroupPrice> gp = aStoreItem.getGroupPrices();
			for( int j =0; j<gp.size(); j++)
			{
				GroupPrice ggp = gp.get(j);
				System.out.println("After buying " + ggp.getNumberToBuyToGetPrice() +
						" Items discount group price is " + ggp.getPriceInCents());
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store store = new Store("Departmental Store");
		Item bread = new Item(true, true, 100);
		Item drinks = new Item(false, true , 15);
		Item pen = new Item( false, true , 20);
		MembershipCardType premium = new MembershipCardType("specialMiles");
		MembershipCard card1 = new MembershipCard(12233 , premium);
		SpecialPrice sp1 = new SpecialPrice(10, drinks, premium);
		GroupPrice gp1 = new GroupPrice(13, 10, drinks);
		Purchase pur1 = new Purchase("3", drinks);
		
		store.addItem(pen);
		store.addItem(drinks);
		store.addItem(bread);
		
		fun(store);
		
	}

}
