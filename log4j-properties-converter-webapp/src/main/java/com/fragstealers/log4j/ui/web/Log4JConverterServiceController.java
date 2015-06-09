/*
 * Copyright (C) 2015 Jason Royals <log4j-converter@fragstealers.com>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 */
package com.fragstealers.log4j.ui.web;

import com.fragstealers.log4j.core.Log4JPropertiesConverter;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Properties;

@RestController
@RequestMapping("/convert")
public class Log4JConverterServiceController {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(Log4JConverterServiceController.class);
    private final Log4JPropertiesConverter log4JPropertiesConverter;

    @Autowired
    public Log4JConverterServiceController(Log4JPropertiesConverter log4JPropertiesConverter) {
        this.log4JPropertiesConverter = log4JPropertiesConverter;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/xml")
    public ResponseEntity<String> convert(@RequestParam("props") final String propsAsText) throws IOException {
        LOGGER.info("Preparing to process a Log4J Properties file");
        LOGGER.debug("Contents of the file: " + propsAsText);
        Properties props = new Properties();
        props.load(IOUtils.toInputStream(propsAsText));

        StringWriter dest = new StringWriter();
        log4JPropertiesConverter.toXml(props, dest);
        final String xmlContent = dest.toString();

        LOGGER.info("XML file was generated");
        LOGGER.debug("Contents of the XML file: " + xmlContent);
        return new ResponseEntity<>(xmlContent, HttpStatus.OK);
    }
}
