package view.handlebars.helper;

import com.github.jknack.handlebars.TypeSafeTemplate;

import model.bean.DefaultUser;



public interface UserTemplate extends TypeSafeTemplate<DefaultUser>{
//on peut ajouter manuellement grace a la ligne plus bas
    public UserTemplate setName(String Nom);
   
}
