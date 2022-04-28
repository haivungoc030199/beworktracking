package com.bework.beworktracking.entity;

import org.hibernate.validator.constraints.NotEmpty;

import java.sql.Timestamp;
import java.util.Objects;

public class PermissionRole {
	private long id;
	private String type;
	private String code;
	private String name;
	private String moduleName;
	private String moduleCode;
	private String description;
	private Integer isPublic;
	private long districtId;
	private String districtNo;
	private long createdBy;
	private long updatedBy;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	public PermissionRole(){
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getIsPublic() {
		return this.isPublic;
	}

	public void setIsPublic(Integer isPublic) {
		this.isPublic = isPublic;
	}

	public long getDistrictId() {
		return this.districtId;
	}

	public void setDistrictId(long districtId) {
		this.districtId = districtId;
	}

	public String getDistrictNo() {
		return this.districtNo;
	}

	public void setDistrictNo(String districtNo) {
		this.districtNo = districtNo;
	}

	public long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PermissionRole that = (PermissionRole) o;
		return code.equals(that.code);
	}

	@Override
	public int hashCode() {
		return Objects.hash(code);
	}
}
