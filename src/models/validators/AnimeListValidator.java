package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.AnimeList;

public class AnimeListValidator {
    public static List<String> validate(AnimeList a) {
        List<String> errors = new ArrayList<String>();

        String title_error = _validateTitle(a.getTitle());
        if(!title_error.equals("")) {
            errors.add(title_error);
        }

        String company_error = _validateCompany(a.getCompany());
        if(!company_error.equals("")) {
            errors.add(company_error);
        }

        String staff_error = _validateStaff(a.getStaff());
        if(!staff_error.equals("")) {
            errors.add(staff_error);
        }

        String summary_error = _validateSummary(a.getSummary());
        if(!summary_error.equals("")) {
            errors.add(summary_error);
        }

        String music_error = _validateMusic(a.getMusic());
        if(!music_error.equals("")) {
            errors.add(music_error);
        }

        String cast_error = _validateCast(a.getCast());
        if(!cast_error.equals("")) {
            errors.add(cast_error);
        }

        return errors;
    }

    private static String _validateTitle(String title) {
        if(title == null || title.equals("")) {
            return "タイトルを入力してください。";
            }
        return "";
    }

    private static String _validateCompany(String company) {
        if(company == null || company.equals("")) {
            return "制作会社名を入力してください。";
            }
        return "";
    }

    private static String _validateStaff(String staff) {
        if(staff == null || staff.equals("")) {
            return "スタッフを入力してください。";
            }
        return "";
    }

    private static String _validateSummary(String summary) {
        if(summary == null || summary.equals("")) {
            return "あらすじを入力してください。";
            }
        return "";
    }

    private static String _validateMusic(String music) {
        if(music == null || music.equals("")) {
            return "OP・EDを入力してください。";
        }
        return "";
    }

    private static String _validateCast(String cast) {
        if(cast == null || cast.equals("")) {
            return "出演者を入力してください。";
            }

        return "";
    }

}
