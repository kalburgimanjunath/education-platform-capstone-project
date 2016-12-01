package edu.umdearborn.astronomyapp.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "courseUserId"))
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"userId", "courseId"}),
    indexes = @Index(columnList = "userId"))
public class CourseUser extends AbstractGeneratedId {

  private static final long serialVersionUID = 453757782768837852L;

  public static enum CourseRole {
    STUDENT, TA, INSTRUCTOR, NUL;
  }

  @JsonUnwrapped
  @Valid
  @NotNull
  @ManyToOne
  @JoinColumn(name = "userId", updatable = false)
  private AstroAppUser user;

  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
  @JsonIdentityReference(alwaysAsId = true)
  @JsonProperty("courseId")
  @Valid
  @NotNull
  @ManyToOne
  @JoinColumn(name = "courseId", updatable = false)
  private Course course;

  @JsonProperty("courseRole")
  @NotNull
  @Enumerated(EnumType.STRING)
  private CourseRole role = CourseRole.NUL;

  @NotNull
  private boolean isActive = true;

  public AstroAppUser getUser() {
    return user;
  }

  public void setUser(AstroAppUser user) {
    this.user = user;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public CourseRole getRole() {
    return role;
  }

  public void setRole(CourseRole role) {
    this.role = role;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean isActive) {
    this.isActive = isActive;
  }

  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}
