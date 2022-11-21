package it.ibs.tourismsquare.config.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import it.ibs.tourismsquare.model.dao.UserMeta;
import it.ibs.tourismsquare.repository.UserMetaRepository;
import lombok.extern.apachecommons.CommonsLog;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtils jwtTokenUtil;
	
	@Autowired
	private UserMetaRepository userMetaRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

			// JWT Token is in the form "Bearer token". Remove Bearer word and
			// get  only the Token
			String jwtToken = extractJwtFromRequest(request);

			if (StringUtils.hasText(jwtToken) && userMetaRepository.findByToken(jwtToken)!=null) {
				UserDetails userDetails = new User(jwtTokenUtil.getUsernameFromToken(jwtToken), "",
						jwtTokenUtil.getRolesFromToken(jwtToken));

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				// After setting the Authentication in the context, we specify
				// that the current user is authenticated. So it passes the
				// Spring Security Configurations successfully.
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			} else {
				System.out.println("Cannot set the Security Context");
			}
		chain.doFilter(request, response);
	}

	private String extractJwtFromRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7, bearerToken.length());
		}
		return null;
	}

}
