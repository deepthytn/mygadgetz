package controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.ui.Model;
import com.google.gson.Gson;
import javax.servlet.http.HttpServletRequest;

import daoservice.DaoIServ;
import dao.DaoI;

import model.MyProduct;
import model.UserRegisteration;

@Controller
public class MyController {
	@Autowired
	DaoIServ dc;
	List<MyProduct> plist=null;
	Path path;
	String message = "Welcome ! ";
	String setName = ""; 
	
	@RequestMapping("/")
	public String myhome(){
		
		return "myhome";
	}
	@RequestMapping("/logout")
	public String mylogout(){
		
		return "myhome";
	}
	
	
	
	@RequestMapping("/allp")
	public String allp(){
		
		return "allproducts";
	}
	@RequestMapping("/registerUser")
	public String reg(){
		
		return "register";
	}
	/*list all products*/
	@RequestMapping("/productlist")
		public String product()
	{
		
	
		return "productlist";
	}
	@RequestMapping("/p")
	public @ResponseBody String getValues()
	{	
		plist=dc.getAll();
		Gson gson=new Gson();
		String result= gson.toJson(plist);
		return result;
		//return "login";
		 
		}
	
	/*add product
	 * 
	 *  @RequestMapping(value="/item/addItem", method = RequestMethod.POST)
    public String addItemPost(@Valid @ModelAttribute("item") Item item, BindingResult result,
                                 HttpServletRequest request,Model model) {
    	
    	addCategoryList();

        model.addAttribute("categoryList", categoryList);

        if(result.hasErrors()) {
            return "addItem";
        }

        itemService.addItem(item);

        MultipartFile itemImage = item.getItemImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\"+item.getItemId()+".png");


        if (itemImage != null && !itemImage.isEmpty()) {
            try {
            	itemImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("item image saving failed.", e);
            }
        }

        return "redirect:/admin/furnitureinventory";
    }
    /*
	 * */
	@RequestMapping("/add")
	 public ModelAndView getForm(@ModelAttribute("p") MyProduct p) {
		
 return new ModelAndView("myproduct");
}
	
	@RequestMapping(value={"/addProduct"},method=RequestMethod.POST)
	public ModelAndView adding(@ModelAttribute("p") MyProduct p)
	{
		
		dc.addproduct(p);;//calls service method
		

	return new ModelAndView("redirect:productlist");
	}
	
	 @RequestMapping("edit")
	 public ModelAndView editUser(@RequestParam int id, @ModelAttribute("p") MyProduct p,BindingResult result) {
	  MyProduct pObject = dc.getRowById(id);
	  return new ModelAndView("editproduct", "employeeObject", pObject);
	 }
	 @RequestMapping("update")
	 public ModelAndView updateUser(@ModelAttribute MyProduct p) {
	  dc.updateRow(p);
	  return new ModelAndView("redirect:productlist");
	 }
	 @RequestMapping("delete")
	 public ModelAndView deletepro(@RequestParam int id)
	 {
		 MyProduct po=dc.getRowById(id);
		 dc.deleterow(po);
		 return new ModelAndView("redirect:productlist");
		 
	 }
	 
	 
	 @RequestMapping(value = "/admin**", method = RequestMethod.GET)
		public ModelAndView adminPage() {

			ModelAndView model = new ModelAndView();
			model.addObject("title", "Spring Security Hello World");
			model.addObject("message", "This is protected page!");
			model.addObject("m1","admin123");
			model.setViewName("admin");

			return model;

		}
	 @RequestMapping("/loginPage")
		public ModelAndView showLoginPage()
		{
		 System.out.println("dddddddddddddd");
		 
			ModelAndView mv = new ModelAndView("login");
			return mv;
		}
	 @RequestMapping("/loginPage1")
		public ModelAndView showLoginPage1()
		{
			ModelAndView mv = new ModelAndView("login1");
			return mv;
		}
	 
	 @RequestMapping(value = { "/welcome**" }, method = RequestMethod.GET)
		public ModelAndView defaultPage() {

			ModelAndView model = new ModelAndView();
			model.addObject("title", "Spring Security Login Form - Database Authentication");
			model.addObject("message", "This is default page!");
			model.addObject("m1","user123");
			model.setViewName("hello");
			return model;

		}
	 @RequestMapping(value = "/403", method = RequestMethod.GET)
		public ModelAndView accesssDenied() {

			ModelAndView model = new ModelAndView();
			String reg=null;
			//check if user is login
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (!(auth instanceof AnonymousAuthenticationToken)) {
				UserRegisteration userDetail = (UserRegisteration) auth.getPrincipal();
				System.out.println(userDetail);
			
				model.addObject("username", userDetail.getusername());
				
				
			}
			
			model.setViewName("403");
			return model;

		}

	 
	 
	 
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
		public ModelAndView login(@RequestParam(value = "error", required = false) String error,
				@RequestParam(value = "logout", required = false) String logout) {

			ModelAndView model = new ModelAndView();
			if (error != null) {
				model.addObject("error", "Invalid username and password!");
			}

			if (logout != null) {
				model.addObject("msg", "You've been logged out successfully.");
			}
			model.setViewName("login");

			return model;

		}
	

}
