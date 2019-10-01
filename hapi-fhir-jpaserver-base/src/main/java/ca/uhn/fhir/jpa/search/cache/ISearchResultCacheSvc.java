package ca.uhn.fhir.jpa.search.cache;

/*-
 * #%L
 * HAPI FHIR JPA Server
 * %%
 * Copyright (C) 2014 - 2019 University Health Network
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import ca.uhn.fhir.jpa.entity.Search;

import java.util.List;

public interface ISearchResultCacheSvc {
	/**
	 * @param theSearch                       The search - This method is not required to persist any chances to the Search object, it is only provided here for identification
	 * @param thePreviouslyStoredResourcePids A list of resource PIDs that have previously been saved to this search
	 * @param theNewResourcePids              A list of new resoure PIDs to add to this search (these ones have not been previously saved)
	 */
	void storeResults(Search theSearch, List<Long> thePreviouslyStoredResourcePids, List<Long> theNewResourcePids);

	/**
	 * Fetch a sunset of the search result IDs from the cache
	 *
	 * @param theSearch The search to fetch IDs for
	 * @param theFrom   The starting index (inclusive)
	 * @param theTo     The ending index (exclusive)
	 * @return A list of resource PIDs
	 */
	List<Long> fetchResultPids(Search theSearch, int theFrom, int theTo);

	/**
	 * Fetch all result PIDs for a given search with no particular order required
	 * @param theSearch
	 * @return
	 */
	List<Long> fetchAllResultPids(Search theSearch);
}
