package com.memverse.datacontracts;

/**
 * Model object for a Verse.
 * <p>
 * Created by amy on 10/12/17.
 */

public class Verse {

    public final Long id;
    public final String translation;
    public final Long bookIndex;
    public final String book;
    public final String chapter;
    public final Long versenum;
    public final String text;
    public final String createdAt;
    public final String updatedAt;
    public final Boolean verified;
    public final Boolean errorFlag;
    // public final Long uberverseId;
    public final String checkedBy;
    // public final Long memversesCount;
    // public final BigDecimal difficulty;
    // public final BigDecimal popularity;

    public Verse(Long id, String translation, Long bookIndex, String book, String chapter, Long versenum, String text, String createdAt, String updatedAt, Boolean verified, Boolean errorFlag, String checkedBy) {
        this.id = id;
        this.translation = translation;
        this.bookIndex = bookIndex;
        this.book = book;
        this.chapter = chapter;
        this.versenum = versenum;
        this.text = text;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.verified = verified;
        this.errorFlag = errorFlag;
        this.checkedBy = checkedBy;
    }
}