package com.nam.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nam.dto.NewDTO;
import com.nam.service.INewService;



@RestController // =@controller +@responbody
public class NewAPI {
	@Autowired
	private INewService newService;

   //@RequestMapping(value = "/new", method = RequestMethod.POST)
   @PostMapping(value = "/new") // = @Requesmapping+ method
   
	 /* @ResponseBody //giúp trả về clien từ dto->json
	 */ public NewDTO createNew(@RequestBody /* chuyển dto thành json */ NewDTO model) {
      return newService.save(model);
   }

    //testgitdfsdffgdgdgdg
    //testmaster
   @PutMapping(value = "/new/{id}")
   public NewDTO updateNew(@RequestBody NewDTO model, @PathVariable("id") long id) {
	   model.setId(id);
	   return newService.save(model);
   }
   @DeleteMapping(value = "/new")
	public void deleteNew(@RequestBody long[] ids) {
	   newService.delete(ids);
	}
}
