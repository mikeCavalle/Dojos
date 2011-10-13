package com.houston.dojo.fruitwheel;

public class Symbol {

	final String presentetation;

	public Symbol(String presentation) {
		this.presentetation = presentation;
	}

	@Override
	public String toString() {
		return presentetation;
	}

	@Override
	public int hashCode() {
		return presentetation.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Symbol other = (Symbol) obj;
		if (presentetation == null) {
			if (other.presentetation != null)
				return false;
		} else if (!presentetation.equals(other.presentetation))
			return false;
		return true;
	}

}
