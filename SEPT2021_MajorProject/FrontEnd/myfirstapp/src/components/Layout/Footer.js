import React from "react";
import { getUser } from "../../actions/userActions";
import { logout } from "../../actions/securityActions";
import securityReducer from "../../reducers/securityReducer";
import store from "../../store";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
Box,
Container,
Row,
Column,
FooterLink,
Heading,
Rights,
} from "../Layout/FooterStyles";

const Footer = () => {
return (
	<Box>
	<Container>
		<Row>
		<Column>
			<Heading>About Us</Heading>
			<FooterLink href="/AboutUs">Aim</FooterLink>
			<FooterLink href="/AboutUs">Background</FooterLink>
		</Column>
		<Column>
			<Heading>Contact Us</Heading>
			<FooterLink href="/ContactUs">Support</FooterLink>
			<FooterLink href="#">Connect</FooterLink>  
		</Column>
		</Row>
    <Rights>
      C. 2021 Bookaroo Ltd. All Rigths Reserved. "Bookeroo" is a trademark of Bookeroo Ltd.
    </Rights>
	</Container>
	</Box>
);
};
export default Footer;
