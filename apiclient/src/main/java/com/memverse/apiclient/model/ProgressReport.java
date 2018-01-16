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


package com.memverse.apiclient.model;

import com.google.gson.annotations.SerializedName;

import org.threeten.bp.LocalDate;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * ProgressReport
 */
public class ProgressReport {
    @SerializedName("user_id")
    private Long userId = null;

    @SerializedName("entry_date")
    private LocalDate entryDate = null;

    @SerializedName("learning")
    private Long learning = null;

    @SerializedName("memorized")
    private Long memorized = null;

    @SerializedName("time_allocation")
    private Long timeAllocation = null;

    @SerializedName("consistency")
    private Long consistency = null;

    public ProgressReport userId(Long userId) {
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

    public ProgressReport entryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
        return this;
    }

    /**
     * Get entryDate
     *
     * @return entryDate
     **/
    @ApiModelProperty(required = true, value = "")
    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public ProgressReport learning(Long learning) {
        this.learning = learning;
        return this;
    }

    /**
     * Get learning
     *
     * @return learning
     **/
    @ApiModelProperty(required = true, value = "")
    public Long getLearning() {
        return learning;
    }

    public void setLearning(Long learning) {
        this.learning = learning;
    }

    public ProgressReport memorized(Long memorized) {
        this.memorized = memorized;
        return this;
    }

    /**
     * Get memorized
     *
     * @return memorized
     **/
    @ApiModelProperty(required = true, value = "")
    public Long getMemorized() {
        return memorized;
    }

    public void setMemorized(Long memorized) {
        this.memorized = memorized;
    }

    public ProgressReport timeAllocation(Long timeAllocation) {
        this.timeAllocation = timeAllocation;
        return this;
    }

    /**
     * Get timeAllocation
     *
     * @return timeAllocation
     **/
    @ApiModelProperty(required = true, value = "")
    public Long getTimeAllocation() {
        return timeAllocation;
    }

    public void setTimeAllocation(Long timeAllocation) {
        this.timeAllocation = timeAllocation;
    }

    public ProgressReport consistency(Long consistency) {
        this.consistency = consistency;
        return this;
    }

    /**
     * Get consistency
     *
     * @return consistency
     **/
    @ApiModelProperty(required = true, value = "")
    public Long getConsistency() {
        return consistency;
    }

    public void setConsistency(Long consistency) {
        this.consistency = consistency;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProgressReport progressReport = (ProgressReport) o;
        return Objects.equals(this.userId, progressReport.userId) &&
                Objects.equals(this.entryDate, progressReport.entryDate) &&
                Objects.equals(this.learning, progressReport.learning) &&
                Objects.equals(this.memorized, progressReport.memorized) &&
                Objects.equals(this.timeAllocation, progressReport.timeAllocation) &&
                Objects.equals(this.consistency, progressReport.consistency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, entryDate, learning, memorized, timeAllocation, consistency);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProgressReport {\n");

        sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
        sb.append("    entryDate: ").append(toIndentedString(entryDate)).append("\n");
        sb.append("    learning: ").append(toIndentedString(learning)).append("\n");
        sb.append("    memorized: ").append(toIndentedString(memorized)).append("\n");
        sb.append("    timeAllocation: ").append(toIndentedString(timeAllocation)).append("\n");
        sb.append("    consistency: ").append(toIndentedString(consistency)).append("\n");
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

