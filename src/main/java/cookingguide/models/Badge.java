package cookingguide.models;

public enum Badge {

    NEWBIE("newbie"),
    INTERMEDIATE("intermediate"),
    ADVANCED("advanced");

    private String badgeWording;
    private Badge(String badgeWording){
        this.badgeWording = badgeWording;

    }

    public String getBadgeWording() {
        return badgeWording;
    }
}


