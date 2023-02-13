package com.example.sceduledtask;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.model.SellShare;
import com.example.model.Share;
import com.example.model.User;
import com.example.repository.SellShareRepository;
import com.example.service.OrderLedgerService;
import com.example.service.SellShareService;
import com.example.service.ShareLedgerService;
import com.example.service.ShareService;
import com.example.service.UserService;

import java.time.LocalDate;

@Component
public class ScheduledTasks {

	@Autowired
	ShareService shareService;
	
	@Autowired
	SellShareService sellShareService;
	
	@Autowired
	OrderLedgerService orderLedgerService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ShareLedgerService shareLedgerService;
	
	 @Scheduled(cron = "* */2 * * * *")
	 public void triggerSelling(){
			System.out.println("Function trigger called");
		 List<SellShare> sells = sellShareService.getUnsoldShare();
		try {
		 for(SellShare ss: sells) {
			 Share sh = shareService.getShareByName(ss.getShareName());
			 if(sh.getPrice() >= ss.getMinSellPrice()) {
				System.out.println("Function triggered : "+sh.getName()+" SOLD");
				User user = userService.getUser(ss.getLoginId());
				int newBalance = user.getBalance() + orderLedgerService.getByLoginIdAndShare(ss.getLoginId(), ss.getShareName()).stream().mapToInt(i->i.getQuantity()).sum()*sh.getPrice();
				userService.updateBalance(ss.getLoginId(),newBalance );
				shareLedgerService.deleteByLoginIdAndShareName(ss.getLoginId(), ss.getShareName());
				sellShareService.updateSellShareStatus(ss.getLoginId(), ss.getShareName(),"SOLD");
			    //sellShareService.delete(ss.getSellShareId());
			 }
		 }
			 
		 
		}
		catch(Exception e) {
			
		}
	}

	
	 @Scheduled(fixedRate = 10000)
	 public void updateShare() {
		
		LocalDate ld = LocalDate.now();
		int a = 0;
		if(ld.getDayOfMonth()%2==0 || ld.getDayOfYear()%2==0 || ld.getMonthValue()%2 ==0 || ld.getYear()%2==0) {a = 1;}
		else {a = -1;} 
		//System.out.println("its working");
		List<Share> shares = shareService.getAllShare();
		for(Share s : shares) {
			int newPrice =s.getPrice()+ (int)(Math.ceil((s.getPrice()/100)*(Math.PI/100)));
			shareService.updatePrice(s.getShareId(), newPrice);
		}
		//shares.forEach(i->shareService.updatePrice(i.getShareId(), i.getPrice()+(i.getPrice()%(LocalDate.now().getDayOfMonth()))));
	}
	
 @Scheduled(cron ="@hourly")
 public void updateSharesEveryHour() {
	
	LocalDate ld = LocalDate.now();
	int a = 0;
	if(ld.getDayOfMonth()%2!=0 || ld.getDayOfYear()%2==0 || ld.getMonthValue()%2 !=0 || ld.getYear()%2==0) {a = 1;}
	else {a = -1;} 
	System.out.println("hourly : working");
	List<Share> shares = shareService.getAllShare();
	for(Share s : shares) {
		int newPrice =s.getPrice()+(int)Math.ceil(((s.getPrice()*(Math.PI/100))*a));
		shareService.updatePrice(s.getShareId(), newPrice);
	}
	//shares.forEach(i->shareService.updatePrice(i.getShareId(), i.getPrice()+(i.getPrice()%(LocalDate.now().getDayOfMonth()))));
}
 
 @Scheduled(cron ="@daily")
 public void updateSharesEveryDay() {
	
	LocalDate ld = LocalDate.now();
	int a = 0;
	if(ld.getDayOfMonth()%2==0 || ld.getDayOfYear()%2==0 || ld.getMonthValue()%2 ==0 || ld.getYear()%2==0) {a = 1;}else {a = -1;} 
	System.out.println("daily : its working");
	List<Share> shares = shareService.getAllShare();
	for(Share s : shares) {
		int newPrice =s.getPrice()-(int) Math.ceil(((s.getPrice()/100)*5));
		shareService.updatePrice(s.getShareId(), newPrice);
	}
	//shares.forEach(i->shareService.updatePrice(i.getShareId(), i.getPrice()+(i.getPrice()%(LocalDate.now().getDayOfMonth()))));
}
 

 
 
}