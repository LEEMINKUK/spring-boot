package com.ohgiraffers.crud.menu.controller;


import com.ohgiraffers.crud.menu.model.dto.CategoryDTO;
import com.ohgiraffers.crud.menu.model.dto.MenuDTO;
import com.ohgiraffers.crud.menu.model.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping("/menu")
@SessionAttributes("code")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService){
        this.menuService = menuService;
    }

    @GetMapping("/list")
    public String findMenuList(Model model){

        List<MenuDTO> menuList = menuService.findAllMenu();

        for (MenuDTO menus : menuList){
            System.out.println("menus = " + menus);
        }

        model.addAttribute("menuList", menuList);

        return "menu/list";
    }

    @GetMapping(value = "category" , produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<CategoryDTO> findCategoryList(){

        return menuService.findAllCategory();
    }

    @GetMapping("/regist")
    public void registPage(){}
    @PostMapping("/regist")
    public String registMenu(MenuDTO newMenu , RedirectAttributes rttr){

        menuService.registNewMenu(newMenu);

        rttr.addFlashAttribute("successMessage","신규 메뉴 등록 성공");

        return "redirect:/menu/list";
    }


    @GetMapping("/update")
    public String updateMenu(Model model){

        List<MenuDTO> menuList = menuService.findAllMenu();

        for (MenuDTO menus : menuList){
            System.out.println("menus = " + menus);
        }

        model.addAttribute("menuList", menuList);

        return "/menu/update";
    }

    @GetMapping("/update2")
    public String updateMenu2(Model model){
        List<MenuDTO> menuList = menuService.findAllMenu();
        for (MenuDTO menus : menuList){
            System.out.println("menus = " + menus);
        }
        model.addAttribute("menuList", menuList);

        return "/menu/update2";
    }

    @PostMapping("/update2")
    public String updateMenu(MenuDTO menuDTO, RedirectAttributes rttr){

        menuService.updateMenu(menuDTO);
        rttr.addFlashAttribute("successMessage", "수정 성공");

        return "redirect:/menu/update2";
    }
    @GetMapping("/delete")
    public String delete(Model model){
        List<MenuDTO> menuList = menuService.findAllMenu();
        for (MenuDTO menus : menuList){
            System.out.println("menus = " + menus);
        }
        model.addAttribute("menuList", menuList);
        return "/menu/delete";
    }
    @PostMapping("/delete")
    public String delete2(MenuDTO menuDTO, RedirectAttributes rttr){
        menuService.deleteMenu(menuDTO);
        rttr.addFlashAttribute("successMessage", "삭제 성공");

        return "redirect:/menu/delete";
    }

}
