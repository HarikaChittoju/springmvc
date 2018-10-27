package com.cg.springmvcpractice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cg.springmvcpractice.dto.Mobile;
import com.cg.springmvcpractice.service.IMobileService;
@Controller
public class MobileController {

	@Autowired
	IMobileService mobileservice;
	@RequestMapping(value="/home")
	public String getAllMobile(@ModelAttribute("my") Mobile mob,Map<String,Object>model){
		List<String> myList = new ArrayList<>();
		myList.add("Android");
		myList.add("Ios");
		myList.add("Windows");
	   
		model.put("cato",myList);
		return "AddMobile";
	
	}
		@RequestMapping(value="adddata",method=RequestMethod.POST)
		public String addMobileData(@Valid@ModelAttribute("my") Mobile mobile,
				BindingResult result,Map<String,Object>model){
			if(result.hasErrors()){
				List<String> myList = new ArrayList<>();
				myList.add("Android");
				myList.add("Ios");
				myList.add("Windows");
			   
				model.put("cato",myList);
				
				
				return "AddMobile";
			}
			mobileservice.addMobile(mobile);
			/*System.out.println(mobile.getMobId()+" "+mobile.getMobName()+" "+mobile.getMobPrice()+" "+mobile.getMobCategory());
			System.out.println(mobile.getMobOnline()+" "+mobile.getMobCategory());*/
			return "success";
		}
		@RequestMapping(value="showall",method=RequestMethod.GET)
		public ModelAndView showAllMobileData(){
			List<Mobile> allMobile=mobileservice.showAllMobile();
			System.out.println(allMobile);
			return new ModelAndView("mobileshow","data", allMobile);
			
			//view name = jsp,,,modelname=data or table..... ,,modelObject=allMobile
		//i.e all mobile data is put in "data"
		}
		@RequestMapping(value="searchmobile",method=RequestMethod.GET)
		public String searchData(@ModelAttribute("yy") Mobile mob){
			return "searchmobile";
		}
		@RequestMapping(value="mobilesearch",method=RequestMethod.POST)
		public ModelAndView dataSearch(@ModelAttribute("yy") Mobile mob){
			Mobile mobSearch=mobileservice.searchMobile(mob.getMobId());
	
			return new ModelAndView("showsearch","temp",mobSearch);
			
		}
		@RequestMapping(value="deletemobile",method=RequestMethod.GET)
		public String deleteData(@ModelAttribute("ss") Mobile mob){
			
			return "deletemobile";
			
			
		}
		@RequestMapping(value="mobiledelete",method=RequestMethod.POST)
		public String dataDelete(@ModelAttribute("ss") Mobile mob){
			mobileservice.deleteMobile(mob.getMobId());
			return "mobiledelete";
			
			
			}
		@RequestMapping(value="updatemobile",method=RequestMethod.GET)
		public String updatemobile(@ModelAttribute("uu") Mobile mob ){
			return "updatemobile";
			}
		@RequestMapping(value="mobileupdate",method=RequestMethod.POST)
		public String dataUpdate(@ModelAttribute("ss") Mobile mob){
			mobileservice.updateMobile(mob.getMobId(),mob.getMobPrice());
			return "mobileupdate";
		
}
}