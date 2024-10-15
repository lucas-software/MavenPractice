package org.example;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SportsDataParser extends DefaultHandler {

    boolean bLeagueId = false;
    boolean bNbaId = false;
    boolean bSport = false;
    boolean bNumberOfTeams = false;
    boolean bTeamName = false;
    boolean bConference = false;
    boolean bCoachName = false;

    public static void main(String[] args) {

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            SportsDataParser handler = new SportsDataParser();
            saxParser.parse("sports_data.xml", handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("league_id")) {
            bLeagueId = true;
        } else if (qName.equalsIgnoreCase("nba_id")) {
            bNbaId = true;
        } else if (qName.equalsIgnoreCase("sport")) {
            bSport = true;
        } else if (qName.equalsIgnoreCase("numberOfTeams")) {
            bNumberOfTeams = true;
        } else if (qName.equalsIgnoreCase("name") && attributes.getLength() == 0) {
            bTeamName = true;
        } else if (qName.equalsIgnoreCase("conference")) {
            bConference = true;
        } else if (qName.equalsIgnoreCase("name")) {
            bCoachName = true;
        }
    }

    public void characters(char ch[], int start, int length) throws SAXException {
        if (bLeagueId) {
            System.out.println("League ID: " + new String(ch, start, length));
            bLeagueId = false;
        } else if (bNbaId) {
            System.out.println("NBA ID: " + new String(ch, start, length));
            bNbaId = false;
        } else if (bSport) {
            System.out.println("Sport: " + new String(ch, start, length));
            bSport = false;
        } else if (bNumberOfTeams) {
            System.out.println("Number of Teams: " + new String(ch, start, length));
            bNumberOfTeams = false;
        } else if (bTeamName) {
            System.out.println("Team Name: " + new String(ch, start, length));
            bTeamName = false;
        } else if (bConference) {
            System.out.println("Conference: " + new String(ch, start, length));
            bConference = false;
        } else if (bCoachName) {
            System.out.println("Coach Name: " + new String(ch, start, length));
            bCoachName = false;
        }
    }
}

