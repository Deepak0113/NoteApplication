package createnote;

import dto.User;

public class CreateNoteController implements CreateNoteViewControllerCallback, CreateNoteModelControllerCallback {
    private CreateNoteViewCallback createNoteView;
    private CreateNoteModelCallback createNoteModel;

    CreateNoteController(CreateNoteViewCallback createNoteView) {
        this.createNoteView = createNoteView;
        createNoteModel = new CreateNoteModel(this);
    }


    /*------ NAVIGATION ------*/

    @Override
    public void chooseOption(User user, int option) {
        switch (option){
            case 1 -> createNoteView.createNewNote(user);
            case 2 -> createNoteView.gotoHome(user);
            case 3 -> createNoteView.gotoStart();
            case 9 -> System.exit(0);
            default -> createNoteView.gotoHome(user);
        }
    }


    /*------ CREATE NOTE ------*/

    @Override
    public void createNewNote(User user, String noteTitle) {
        if(noteTitle.trim().equals("")){
            createNoteView.createNewNoteWarning(user, "Empty title. Please enter the title to proceed.");
        } else{
            createNoteModel.createNewNote(noteTitle, user);
        }
    }

    @Override
    public void createNewNoteSuccess(User user, String filePath) {
        createNoteView.createNewNoteSuccess(user, filePath);
    }
}