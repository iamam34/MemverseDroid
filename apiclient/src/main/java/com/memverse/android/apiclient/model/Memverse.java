/*
 * Swagger Memverse
 * Memverse API
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.memverse.android.apiclient.model;

import com.google.gson.annotations.SerializedName;

import org.threeten.bp.LocalDate;

import java.math.BigDecimal;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * Memverse
 * Generated by `java -jar swagger-codegen-cli.jar generate --lang java --library retrofit2 --input-spec swagger_spec.json`
 * Created on 2017-12-30T15:34:14.889+13:00
 */
public class Memverse {
    @SerializedName("id")
    private Long id = null;

    @SerializedName("verse_id")
    private Long verseId = null;

    @SerializedName("user_id")
    private Long userId = null;

    @SerializedName("efactor")
    private BigDecimal efactor = null;

    @SerializedName("test_interval")
    private Long testInterval = null;

    @SerializedName("rep_n")
    private Long repN = null;

    @SerializedName("next_test")
    private LocalDate nextTest = null;

    @SerializedName("status")
    private String status = null;

    @SerializedName("prev_verse")
    private Long prevVerse = null;

    @SerializedName("ref_interval")
    private Long refInterval = null;

    @SerializedName("next_ref_test")
    private LocalDate nextRefTest = null;

    @SerializedName("passage_id")
    private Long passageId = null;

    @SerializedName("subsection")
    private Long subsection = null;

    public Memverse id(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    @ApiModelProperty(value = "")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Memverse verseId(Long verseId) {
        this.verseId = verseId;
        return this;
    }

    /**
     * Get verseId
     *
     * @return verseId
     **/
    @ApiModelProperty(required = true, value = "")
    public Long getVerseId() {
        return verseId;
    }

    public void setVerseId(Long verseId) {
        this.verseId = verseId;
    }

    public Memverse userId(Long userId) {
        this.userId = userId;
        return this;
    }

    /**
     * Get userId
     *
     * @return userId
     **/
    @ApiModelProperty(required = true, value = "")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Memverse efactor(BigDecimal efactor) {
        this.efactor = efactor;
        return this;
    }

    /**
     * Get efactor
     *
     * @return efactor
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getEfactor() {
        return efactor;
    }

    public void setEfactor(BigDecimal efactor) {
        this.efactor = efactor;
    }

    public Memverse testInterval(Long testInterval) {
        this.testInterval = testInterval;
        return this;
    }

    /**
     * Get testInterval
     *
     * @return testInterval
     **/
    @ApiModelProperty(value = "")
    public Long getTestInterval() {
        return testInterval;
    }

    public void setTestInterval(Long testInterval) {
        this.testInterval = testInterval;
    }

    public Memverse repN(Long repN) {
        this.repN = repN;
        return this;
    }

    /**
     * Get repN
     *
     * @return repN
     **/
    @ApiModelProperty(value = "")
    public Long getRepN() {
        return repN;
    }

    public void setRepN(Long repN) {
        this.repN = repN;
    }

    public Memverse nextTest(LocalDate nextTest) {
        this.nextTest = nextTest;
        return this;
    }

    /**
     * Get nextTest
     *
     * @return nextTest
     **/
    @ApiModelProperty(value = "")
    public LocalDate getNextTest() {
        return nextTest;
    }

    public void setNextTest(LocalDate nextTest) {
        this.nextTest = nextTest;
    }

    public Memverse status(String status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     *
     * @return status
     **/
    @ApiModelProperty(value = "")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Memverse prevVerse(Long prevVerse) {
        this.prevVerse = prevVerse;
        return this;
    }

    /**
     * Get prevVerse
     *
     * @return prevVerse
     **/
    @ApiModelProperty(value = "")
    public Long getPrevVerse() {
        return prevVerse;
    }

    public void setPrevVerse(Long prevVerse) {
        this.prevVerse = prevVerse;
    }

    public Memverse refInterval(Long refInterval) {
        this.refInterval = refInterval;
        return this;
    }

    /**
     * Get refInterval
     *
     * @return refInterval
     **/
    @ApiModelProperty(value = "")
    public Long getRefInterval() {
        return refInterval;
    }

    public void setRefInterval(Long refInterval) {
        this.refInterval = refInterval;
    }

    public Memverse nextRefTest(LocalDate nextRefTest) {
        this.nextRefTest = nextRefTest;
        return this;
    }

    /**
     * Get nextRefTest
     *
     * @return nextRefTest
     **/
    @ApiModelProperty(value = "")
    public LocalDate getNextRefTest() {
        return nextRefTest;
    }

    public void setNextRefTest(LocalDate nextRefTest) {
        this.nextRefTest = nextRefTest;
    }

    public Memverse passageId(Long passageId) {
        this.passageId = passageId;
        return this;
    }

    /**
     * Get passageId
     *
     * @return passageId
     **/
    @ApiModelProperty(value = "")
    public Long getPassageId() {
        return passageId;
    }

    public void setPassageId(Long passageId) {
        this.passageId = passageId;
    }

    public Memverse subsection(Long subsection) {
        this.subsection = subsection;
        return this;
    }

    /**
     * Get subsection
     *
     * @return subsection
     **/
    @ApiModelProperty(value = "")
    public Long getSubsection() {
        return subsection;
    }

    public void setSubsection(Long subsection) {
        this.subsection = subsection;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Memverse memverse = (Memverse) o;
        return Objects.equals(this.id, memverse.id) &&
                Objects.equals(this.verseId, memverse.verseId) &&
                Objects.equals(this.userId, memverse.userId) &&
                Objects.equals(this.efactor, memverse.efactor) &&
                Objects.equals(this.testInterval, memverse.testInterval) &&
                Objects.equals(this.repN, memverse.repN) &&
                Objects.equals(this.nextTest, memverse.nextTest) &&
                Objects.equals(this.status, memverse.status) &&
                Objects.equals(this.prevVerse, memverse.prevVerse) &&
                Objects.equals(this.refInterval, memverse.refInterval) &&
                Objects.equals(this.nextRefTest, memverse.nextRefTest) &&
                Objects.equals(this.passageId, memverse.passageId) &&
                Objects.equals(this.subsection, memverse.subsection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, verseId, userId, efactor, testInterval, repN, nextTest, status, prevVerse, refInterval, nextRefTest, passageId, subsection);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Memverse {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    verseId: ").append(toIndentedString(verseId)).append("\n");
        sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
        sb.append("    efactor: ").append(toIndentedString(efactor)).append("\n");
        sb.append("    testInterval: ").append(toIndentedString(testInterval)).append("\n");
        sb.append("    repN: ").append(toIndentedString(repN)).append("\n");
        sb.append("    nextTest: ").append(toIndentedString(nextTest)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    prevVerse: ").append(toIndentedString(prevVerse)).append("\n");
        sb.append("    refInterval: ").append(toIndentedString(refInterval)).append("\n");
        sb.append("    nextRefTest: ").append(toIndentedString(nextRefTest)).append("\n");
        sb.append("    passageId: ").append(toIndentedString(passageId)).append("\n");
        sb.append("    subsection: ").append(toIndentedString(subsection)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

