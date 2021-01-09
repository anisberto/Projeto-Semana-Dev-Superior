import './style.css';
import { ReactComponent as Instagram } from './Instagram.svg';
import { ReactComponent as Linkedin } from './Linkedin.svg';
import { ReactComponent as YouTube } from './Youtube.svg';

function Footer() {
    return (
        <footer className="main-footer">
            <h3>App desenvolvido durante a 2ª ed. do evento Semana DevSuperior</h3>
            <div className="footer-icons">
                <a href="http://youbybe.com/c/devsuperior">
                    <YouTube />
                </a>
                <a href="http://linkedin.com/anisberto">
                    <Linkedin />
                </a>
                <a href="http://instagran.com/anisberto">
                    <Instagram />
                </a>
            </div>
        </footer>
    )
}

export default Footer;