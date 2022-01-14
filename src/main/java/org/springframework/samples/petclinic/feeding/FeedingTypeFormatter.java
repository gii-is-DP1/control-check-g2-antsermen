package org.springframework.samples.petclinic.feeding;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class FeedingTypeFormatter implements Formatter<FeedingType>{

	@Autowired
	FeedingRepository feedingRepository;
	
    @Override
    public String print(FeedingType feedingType, Locale locale) {
        return feedingType.getName();
    }

    @Override
    public FeedingType parse(String text, Locale locale) throws ParseException {
        Collection<FeedingType> feedingTypes = feedingRepository.findAllFeedingTypes();
        for (FeedingType feedingType: feedingTypes) {
        	if (feedingType.getName().equals(text)) {
        		return feedingType;
        	}
        }
        throw new ParseException("Feeding type not found: " + text, 0);
    }
    
}
