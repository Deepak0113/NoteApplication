package createnote;

import dto.User;
import repository.Repository;
import statuscalls.NoteStatusCall;

public class CreateNoteModel implements CreateNoteModelCallback {
    CreateNoteModelControllerCallback createNoteController;

    CreateNoteModel(CreateNoteModelControllerCallback createNoteController) {
        this.createNoteController = createNoteController;
    }

    @Override
    public void createNewNote(String noteTitle, User user) {
        NoteStatusCall noteStatusCall =  Repository.getInstance().createNewNote(noteTitle, user.getUserName());

        switch (noteStatusCall.getStatus()){
            case "SUCCESS" -> createNoteController.createNewNoteSuccess(user, noteStatusCall.getFilePath());
        }
    }
}